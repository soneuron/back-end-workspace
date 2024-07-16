package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
 * 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다.
 * 
 * 클라이언트측 로직
 * 1. 소켓 생성
 * 2. 스트림
 * 
 * */

public class ChattClient {

	public static void main(String[] args) {
		try {
		InetAddress ip = InetAddress.getLocalHost();
		
		Socket s = new Socket(ip.getHostAddress(), 60000);

		
		// 키보드로 입력받은 데이터를 읽어서 서버한테 보낸다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받은거 읽게끔 함
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true); // 입력받은것 소켓에 출력

		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		while(true) {
			String line = br.readLine();
			pw.println(line); 
			// 서버한테 입력한 값 보냄
			
			String serverMsg = br2.readLine();
			System.out.println("내가 보낸 메세지 : " + serverMsg);
		}
		
		} catch(IOException e) {
			System.out.println("Client 연결에 실패했습니다.");
		}
		
		
		
		
		
//		// 1. ServerSocket 생성 - 포트번호  : 60000
//		try {
//		ServerSocket server = new ServerSocket(60000);
//		System.out.println("Server Ready..");
//		
//		// 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
//		Socket s = server.accept();
//		System.out.println("Client Socket..");
//		
//		 3. 소켓으로 부터 스트림 리턴
//		BufferedReader br = new BufferedReader (new InputStreamReader(s.getInputStream()));
//		
//		String line = null;
//		while((line = br.readLine()) != null) {
//			System.out.println("Client가 보낸 메세지 : " + line);
//		}
//		
//		} catch (IOException e) {
//			System.out.println("Client와의 연결이 끊어졌습니다..");
//		}
	}
}
