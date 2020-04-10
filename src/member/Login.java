package member;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {
	JPanel nP, cP, sP, eP;
	JLabel idLabel, pwLabel, joinlabel;
	JTextField idField, pwdField, loginField;
	JButton loginBtn, joinBtn;

	Login() {
		super("��ٱ���");
		createpanel();
		setClose();
	}

	private void createpanel() {
		this.setLayout(new BorderLayout());
		nP = new JPanel();
		nP.setBorder(new EmptyBorder(10, 10, 0, 10));
		idLabel = new JLabel("ID");
		nP.add(idLabel);

		// �ؽ�Ʈ �ʵ� �����
		idField = new JTextField(15);
		nP.add(idField);

		// center �г� �����
		cP = new JPanel();
		pwLabel = new JLabel("�� ȣ");
		pwdField = new JPasswordField(15);

		cP.add(pwLabel);
		cP.add(pwdField);
		// south �г� �����
		sP = new JPanel();
		loginBtn = new JButton("�α���");
		sP.add(loginBtn);

		eP = new JPanel();
		joinBtn = new JButton("ȸ������");
		sP.add(joinBtn);
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);

		// �г� �����ӿ� �ֱ� ��ġ�� ����"".
		this.add(nP, "North");
		this.add(cP, "Center");
		this.add(sP, "South");
		this.add(eP, "East");

		// �� ����
		// this.setBackground(Color,blue);

		// ������ �����ֱ�
		this.setBounds(400, 500, 300, 200);

	}

	public void setClose() {
		// this.setVisible(false);
		// �ڵ����� �����Ը���
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		// true�� ȭ�鿡�� ��Ÿ���� false�� ȭ�鿡�� �������
		this.setVisible(true);
	}

//	private void loginchk() {
//		loginBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MemberDTO member = new MemberDTO();
//				member.setId(idField.getText());
//				member.setPwd(pwdField.getText());
//
//				try {
//					MemberDAO dao = MemberDAO.getInstance();
//					Boolean result = dao.loginchk(member);
//					if (result == true) {
//						if (member.getLv() == 1) {
//							System.out.println("���θ�â �߰��ϱ�");
//						} else if (member.getLv() == 5) {
//							System.out.println("������â �߰� �ϱ� ������ ��ü�� �������� â���� ������");
//						}
//						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
//						dispose();
//					} else if (result == false) {
//						JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵�ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
//						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//						idField.setText("");
//						pwdField.setText("");
//					}
//
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			}
//
//		});
//	}

	private void loginchk() {
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					MemberDAO dao = MemberDAO.getInstance();
					MemberDTO member = dao.loginchk(idField.getText());
					// MemberDTO result = dao.loginchk2(member);
					if (idField.getText().equals(member.getId()) && pwdField.getText().equals(member.getPwd())) {
						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
						if (member.getLv() == 1) {
							System.out.println("���θ�â �߰��ϱ�");
						} else if (member.getLv() == 5) {
							System.out.println("������â �߰� �ϱ� ������ ��ü�� �������� â���� ������");
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵�ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						idField.setText("");
						pwdField.setText("");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		loginchk();
		gosignup();
	}

	private void gosignup() {
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}

		});
	}

}
