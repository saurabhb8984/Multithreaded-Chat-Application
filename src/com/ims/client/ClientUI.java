package com.ims.client;


public class ClientUI extends javax.swing.JFrame{
	
	private javax.swing.JButton b_connectToUser;
	private javax.swing.JButton b_connect;
	private javax.swing.JButton b_disconnect;
	private javax.swing.JButton b_send;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lb_address;
	private javax.swing.JLabel lb_name;
	private javax.swing.JLabel lb_connectToUsername;
	private javax.swing.JLabel lb_port;
	private javax.swing.JLabel lb_username;
	private javax.swing.JTextArea ta_chat;
	private javax.swing.JTextField tf_address;
	private javax.swing.JTextField tf_chat;
	private javax.swing.JTextField tf_connectToUsername;
	private javax.swing.JTextField tf_port;
	private javax.swing.JTextField tf_username;
	
	public ClientUI(){

		lb_address = new javax.swing.JLabel();
		tf_address = new javax.swing.JTextField();
		lb_port = new javax.swing.JLabel();
		tf_port = new javax.swing.JTextField();
		lb_username = new javax.swing.JLabel();
		tf_username = new javax.swing.JTextField();
		lb_connectToUsername = new javax.swing.JLabel();
		tf_connectToUsername = new javax.swing.JTextField();
		b_connect = new javax.swing.JButton();
		b_disconnect = new javax.swing.JButton();
		b_connectToUser = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		ta_chat = new javax.swing.JTextArea();
		tf_chat = new javax.swing.JTextField();
		b_send = new javax.swing.JButton();
		lb_name = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client frame");
		setName("client"); // NOI18N
		setResizable(false);

		lb_address.setText("Address : ");

		tf_address.setText("localhost");
		tf_address.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tf_addressActionPerformed(evt);
			}
		});

		lb_port.setText("Port :");

		tf_port.setText("2222");
		tf_port.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tf_portActionPerformed(evt);
			}
		});

		lb_username.setText("Username :");

		tf_username.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tf_usernameActionPerformed(evt);
			}
		});

		lb_connectToUsername.setText("Connect To User : ");
		tf_connectToUsername.setEditable(false);

		b_connect.setText("Connect To Server");
		b_connect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_connectActionPerformed(evt);
			}
		});

		b_disconnect.setText("Disconnect User");
		b_disconnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_disconnectActionPerformed(evt);
			}
		});

		b_connectToUser.setText("Connect To User");
		b_connectToUser.disable();

		ta_chat.setColumns(20);
		ta_chat.setRows(5);
		jScrollPane1.setViewportView(ta_chat);

		b_send.setText("SEND");
		b_send.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_sendActionPerformed(evt);
			}
		});


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(tf_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(b_send, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
										.addComponent(jScrollPane1)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(lb_username, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
														.addComponent(lb_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(18, 18, 18)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(tf_address, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
																.addComponent(tf_username))
																.addGap(18, 18, 18)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(lb_connectToUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(lb_port, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addComponent(tf_connectToUsername)
																				.addComponent(tf_port, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(layout.createSequentialGroup()
																								.addComponent(b_connect)
																								.addGap(2, 2, 2)
																								.addComponent(b_disconnect)
																								.addGap(0, 0, Short.MAX_VALUE))
																								.addComponent(b_connectToUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																								.addContainerGap())
																								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(lb_name)
																										.addGap(201, 201, 201))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lb_address)
								.addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_port)
								.addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(b_connectToUser))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(tf_username)
										.addComponent(tf_connectToUsername)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lb_username)
												.addComponent(lb_connectToUsername)
												.addComponent(b_connect)
												.addComponent(b_disconnect)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(tf_chat)
														.addComponent(b_send, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(lb_name))
				);

		pack();
	
	}
	
	private void tf_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addressActionPerformed

	}//GEN-LAST:event_tf_addressActionPerformed

	private void tf_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_portActionPerformed

	}//GEN-LAST:event_tf_portActionPerformed

	private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed

	}//GEN-LAST:event_tf_usernameActionPerformed

	private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {
		new ServerHandler().connectToServer(tf_username.getText(),tf_address.getText(),Integer.parseInt(tf_port.getText()));
	}//GEN-LAST:event_b_connectActionPerformed

	private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
		new ServerHandler().disconnectFromServer(tf_username.getText());
	}//GEN-LAST:event_b_disconnectActionPerformed

	private void b_connectToUserActionPerformed(java.awt.event.ActionEvent evt) {
		new ServerHandler().connectToUser(tf_username.getText(), tf_connectToUsername.getText());
		
	}//GEN-LAST:event_b_anonymousActionPerformed

	private void b_sendActionPerformed(java.awt.event.ActionEvent evt) {
		new ServerHandler().sendChatMessage(tf_username.getText(), tf_chat.getText(), tf_connectToUsername.getText());
		
	}//GEN-LAST:event_b_sendActionPerformed
	
	public void afterConnectionToServer(){
		tf_connectToUsername.setEditable(true);
		b_connectToUser.enable();
		tf_username.disable();
		b_connectToUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_connectToUserActionPerformed(evt);
			}
		});
	}
	
	public void clientLog(String data){
		ta_chat.append(data);
	}
	
	public void disableConnectToUsername(String data){
		tf_connectToUsername.setText(data.trim());
		tf_connectToUsername.disable();
	}
	public static void main(String[] args) {
		new ClientUI().setVisible(true);
	}
}
