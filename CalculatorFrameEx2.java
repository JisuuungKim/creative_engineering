import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalculatorFrameEx2 extends JFrame {
	
	public CalculatorFrameEx2() {
		super("ȯ�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new NorthPanel(), BorderLayout.NORTH);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalculatorFrameEx2();
	}


	class SouthPanel extends JPanel {
	   public SouthPanel() {
	      setBackground(Color.YELLOW);
	      setOpaque(true);
	      setLayout(new FlowLayout(FlowLayout.CENTER));
	      JButton change1 = new JButton("(��) -> (�޷�)");
	      JButton change2 = new JButton("(�޷�) -> (��)");
	      change1.addActionListener(new TrueActionListener());
	      add(change1);
	      add(new JLabel("  "));
	      change2.addActionListener(new FalseActionListener());
	      add(change2);
	      
	   }
	  
	}

	class CenterPanel extends JPanel {
	   public CenterPanel() {
		  
	      setBackground(Color.WHITE);
	      JButton[] bt = new JButton[10];
	      setLayout(new GridLayout(4,3,4,4));
	      
	      
	      for(int i=1; i<10; i++) {
	         bt[i] = new JButton(Integer.toString(i));
	         bt[i].addActionListener(new NumActionListener());
	         add(bt[i]);
	         
	      }
	      JButton reset = new JButton("reset");
	      reset.addActionListener(new ResetActionListener());
	      add(reset);
	      JButton zero = new JButton("0");
	      zero.addActionListener(new NumActionListener());
	      add(zero);
	      JButton transform = new JButton("��ȯ");
	      transform.addActionListener(new TransActionListener());
	      add(transform);
	   }
	}

	class NorthPanel extends JPanel {
		JTextField jtf1;
		JTextField jtf2;
		
	   public NorthPanel() {
	      setBackground(Color.LIGHT_GRAY);
	      setOpaque(true);
	      setLayout(new FlowLayout());
	      jtf1 = new JTextField(10);
	      jtf2 = new JTextField(6);
	      add(new JLabel("(��)"));
	      add(jtf1);
	      add(new JLabel("  "));
	      add(new JLabel("(�޷�)"));
	      add(jtf2); }
	} 
	      
	public boolean check = true;	

	class NumActionListener extends NorthPanel implements ActionListener {
	   
	   
	   public void actionPerformed(ActionEvent e) {
		  
	   
	      if(check) {										              // �� -> �޷��� ����
	    	  JButton b = (JButton)e.getSource();
	    	  String oldtext = jtf1.getText();				
	    	  String text = b.getText();					
	    	  String newtext = oldtext + text;
	    	  jtf1.setText(newtext);							        // tf1�� �� ���
	    	}
	      else if(!check) { 
	    	 // �޷� -> ���� ����
	    	  JButton b = (JButton)e.getSource();
	     
	    	  String oldtext = jtf2.getText();			
	    	  String text = b.getText();
	    	  String newtext = oldtext + text;
	    	  jtf2.setText(newtext);							        // tf2�� �� ���
	    	}
	   }
	}

	class ResetActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jtf1.setText("");									//tf1 �ؽ�Ʈ�� ��ĭ����
			jtf2.setText("");									//tf2 �ؽ�Ʈ�� ��ĭ����
		}
	}
	
	class TransActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(check) {											// ���� check�� true�� ���� : ���� ���°� ��->�޷�
				String won = jtf1.getText();						// tf1���� won�� stringŸ������ ����
				double dollor = Double.valueOf(won)*1100.0;		// won�� ����� ���� double�� Ÿ�Ժ�ȯ �� *1100.0 �Ͽ� ����  
				jtf2.setText(String.valueOf(dollor));			// double�� dollor�� string���� Ÿ�Ժ�ȯ �� tf2�� ����
			}	
			else if(!check) {									// ���� check�� false��� ������ ����
				String dollor = jtf2.getText();					// tf2���� double�� stringŸ������ ����
				double won = Double.valueOf(dollor)/1100.0 ;	// dollor�� ����� ���� double�� Ÿ�Ժ�ȯ �� *1100.0 �Ͽ� ����  
				jtf1.setText(String.valueOf(won));				// double�� won�� string���� Ÿ�Ժ�ȯ �� tf1�� ����
			}
			
		}
	}
	
	class TrueActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check = true;											// ���������� check �����Ŀ� ��ư�� �������� true�� ����
		}
	}
	
	class FalseActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check = false;											// ���������� check �����Ŀ� ��ư�� �������� true�� ����
		}
	}
}

