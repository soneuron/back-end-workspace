/*
	서브쿼리(SUBQUERY), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과 값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리(SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (1행 1열)
    - 일반 비교연산자 사용 가능 : =, !=, <>, >, <, >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '노옹철'; -- D9

-- 2) 부서코드가 'D9'인 사원들 조회
SELECT *
FROM employee
WHERE dept_code = 'D9';

-- 3) 위의 2단계를 하나의 쿼리문으로
SELECT *
FROM employee
WHERE dept_code = (SELECT dept_code
				   FROM employee
				   WHERE emp_name = '노옹철');

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT emp_name, avg(salary)
FROM employee
GROUP BY emp_name;

SELECT emp_id, emp_name, dept_code, format(salary, 0) 급여
FROM employee
WHERE salary > (SELECT avg(salary)
				FROM employee)
ORDER BY salary DESC;

-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외
select * from department; -- dept_title
select * from job; -- job_name
select * from employee;

SELECT *
FROM employee
WHERE emp_name = '전지연'; -- dept_code D1

SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee
	JOIN department ON (dept_id = dept_code)
    JOIN job USING (job_code)
WHERE 
	dept_code = (SELECT dept_code
				 FROM employee
				 WHERE emp_name = '전지연')
	AND emp_name != '전지연';

SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee
	JOIN department ON (dept_id = dept_code)
    JOIN job USING (job_code)
WHERE dept_code = 'D1' and emp_name != '전지연';

-- 부서별 급여의 합이가장 큰 부서의 부서 코드, 급여의 합 조회
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
ORDER BY sum(salary) DESC
LIMIT 0, 1;

SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code;

SELECT *
FROM (
	SELECT dept_code, sum(salary) 
	FROM employee
	GROUP BY dept_code
    ) sb;

-- >> 서브쿼리 사용
-- 부서의 합이 가장 큰 값
SELECT max(sum_salary)
FROM (SELECT dept_code, sum(salary) sum_salary
	  FROM employee
      GROUP BY dept_code) dept_sum;

-- 서브쿼리 특징! 쿼리 자체는 직관적!
-- 쿼리 속도 중요! 서브쿼리는 상대적으로 느림
-- 가급적으로 서브쿼리를 사용하지 않아도 되면 안쓰고 하는걸 추천
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_salary) 
					  FROM (SELECT dept_code, sum(salary) sum_salary
							FROM employee
							GROUP BY dept_code) dept_sum);
                            
/*
	2. 다중행 서브쿼리
    - 섯브쿼리의 조회 결과 개수가 여러 행 일 때 (여러행 1열)
    
    IN 쿼리 : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
-- 1) 각 부서별 최고 급여
SELECT max(salary)
FROM employee
GROUP BY dept_code;

-- 2) 위의 값들을 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
SELECT emp_name, job_code, dept_code, salary
FROM employee
WHERE salary IN (SELECT max(salary)
				 FROM employee
                 GROUP BY dept_code);
                 
-- 직원에 대한 사번, 이름, 부서코드, 구분(사수/사원) 조회
select * from employee;

SELECT
	emp_id,
	emp_name,
    dept_code,
    if (manager_id IS NULL, '사수', '사원') 구분
FROM employee
ORDER BY 구분;

SELECT 
	emp_id,
    emp_name,
    dept_code,
    if (emp_id in (SELECT distinct manager_id
				   FROM employee
				   WHERE manager_id is not null) , '사수', '사원') 구분
FROM employee;

SELECT distinct manager_id, emp_id, emp_name
FROM employee
WHERE manager_id is not null; -- 사수 (200 201 204 207 211 214 100

/*
	컬럼 > ANY (서브쿼리) : 여러개의 결과값 중에서 "1개라도" 클 경우
    컬럼 < ANY (서브쿼리) : 여러개의 결과값 중에서 "1개라도" 작을 경우
    --> OR
*/
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
SELECT job_name, emp_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리';

SELECT job_name, emp_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '과장';

SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리'
	AND salary > ANY (SELECT salary
					  FROM employee
						JOIN job USING (job_code)
					  WHERE job_name = '과장');

/*
	컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우
    컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우
    -- >> AND
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 사원들의 사번, 이름, 직급, 급여 조회
SELECT emp_name, job_name, salary
FROM employee
	join job USING (job_code)
WHERE job_name = '차장';

SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '과장'
	AND salary > ALL (SELECT salary
					  FROM employee
						JOIN job USING (job_code)
					  WHERE job_name = '차장');

/*
	3. 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (1행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들의 사원명, 부서코드, 직급코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '하이유'; -- D5

SELECT job_code
FROM employee
WHERE emp_name = '하이유'; -- J5

SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
				   FROM employee
				   WHERE emp_name = '하이유') 
	AND job_code = (SELECT job_code
					FROM employee
					WHERE emp_name = '하이유');

-- 다중열 서브쿼리
SELECT job_code, dept_code
FROM employee
WHERE emp_name = '하이유';

SELECT emp_name, dept_code, job_code
FROM employee
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
							   FROM employee
							   WHERE emp_name = '하이유');

-- 박나라 사원과 직급코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급코드, 사수사번 조회
SELECT job_code, manager_id
FROM employee
WHERE emp_name = '박나라';

SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (SELECT job_code, manager_id
								 FROM employee
								 WHERE emp_name = '박나라');

/*
	4. 다중행 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 여러 행, 여러 열 일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT job_code, min(salary) 
FROM employee
GROUP BY job_code;

SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE (job_code, salary) in (SELECT job_code, min(salary)
							 FROM employee
							 GROUP BY job_code);

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름 , 부서코드, 급여 조회 (부서 없음 명시)
select * from employee;


SELECT dept_code, max(salary)
FROM employee
GROUP BY dept_code;

SELECT emp_id, emp_name, ifnull(dept_code, '부서없음'), salary
FROM employee
WHERE (ifnull(dept_code, '부서없음'), salary) in (SELECT ifnull(dept_code, '부서없음'), max(salary)
												FROM employee
												GROUP BY dept_code);




