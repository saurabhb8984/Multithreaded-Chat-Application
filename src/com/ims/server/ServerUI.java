package com.ims.server;



/*
 * Messaging Server: UI part of Server.
 */
public class ServerUI extends javax.swing.JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JButton b_clear;
	public  javax.swing.JButton b_end;
	public  javax.swing.JButton b_start;
	public  javax.swing.JScrollPane jScrollPane1;
	public  javax.swing.JLabel lb_name;
	public  javax.swing.JTextArea ta_chat;
	// End of variables declaration//GEN-END:variables
	
	public ServerUI(){

		jScrollPane1 = new javax.swing.JScrollPane();
		ta_chat = new javax.swing.JTextArea();
		b_start = new javax.swing.JButton();
		b_end = new javax.swing.JButton();
		b_clear = new javax.swing.JButton();
		lb_name = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server frame");
		setName("server"); // NOI18N
		setResizable(false);

		ta_chat.setColumns(20);
		ta_chat.setRows(5);
		jScrollPane1.setViewportView(ta_chat);

		b_start.setText("START");
		b_start.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_startActionPerformed(evt);
			}
		});

		b_end.setText("END");
		b_end.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_endActionPerformed(evt);
			}
		});

		b_clear.setText("Clear");
		b_clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_clearActionPerformed(evt);
			}
		});

		lb_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(b_end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(b_start, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(b_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
														.addContainerGap())
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lb_name)
																.addGap(209, 209, 209))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(b_start))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(b_clear)
										.addComponent(b_end))
										.addGap(4, 4, 4)
										.addComponent(lb_name))
				);

		pack();

	}

	private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
		try 
		{
			Thread.sleep(5000);                 //5000 milliseconds is five second.
		} 
		catch(InterruptedException ex) {Thread.currentThread().interrupt();}

		//tellEveryone("Server:is stopping and all users will be disconnected.\n:Chat");
		ta_chat.append("Server stopping... \n");
		
		ta_chat.setText("");
	}//GEN-LAST:event_b_endActionPerformed

	private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
		new ServerSocketHandler().createServerSocket();
		ta_chat.append("Server Started...");
	
	}//GEN-LAST:event_b_startActionPerformed

	private void b_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_usersActionPerformed
		/*ta_chat.append("\n Online users : \n");
		Set<String> onlineUsers = users.keySet();
		for (String current_user : onlineUsers)
		{
			ta_chat.append(current_user);
			ta_chat.append("\n");
		}   */ 

	}//GEN-LAST:event_b_usersActionPerformed

	private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
		ta_chat.setText("");
	}//GEN-LAST:event_b_clearActionPerformed



	public void serverlog(String message){
		ta_chat.append(message);
	}

	public static void main(String[] args) {
		new ServerUI().setVisible(true);
	}
}
