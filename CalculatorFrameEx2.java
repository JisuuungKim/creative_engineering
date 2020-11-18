import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalculatorFrameEx2 extends JFrame {
	
	public CalculatorFrameEx2() {
		super("환율 계산기");
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
	      JButton change1 = new JButton("(원) -> (달러)");
	      JButton change2 = new JButton("(달러) -> (원)");
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
	      JButton transform = new JButton("변환");
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
	      add(new JLabel("(원)"));
	      add(jtf1);
	      add(new JLabel("  "));
	      add(new JLabel("(달러)"));
	      add(jtf2); }
	} 
	      
	public boolean check = true;	

	class NumActionListener extends NorthPanel implements ActionListener {
	   
	   
	   public void actionPerformed(ActionEvent e) {
		  
	   
	      if(check) {										              // 원 -> 달러의 상태
	    	  JButton b = (JButton)e.getSource();
	    	  String oldtext = jtf1.getText();				
	    	  String text = b.getText();					
	    	  String newtext = oldtext + text;
	    	  jtf1.setText(newtext);							        // tf1에 값 기록
	    	}
	      else if(!check) { 
	    	 // 달러 -> 원의 상태
	    	  JButton b = (JButton)e.getSource();
	     
	    	  String oldtext = jtf2.getText();			
	    	  String text = b.getText();
	    	  String newtext = oldtext + text;
	    	  jtf2.setText(newtext);							        // tf2에 값 기록
	    	}
	   }
	}

	class ResetActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jtf1.setText("");									//tf1 텍스트를 빈칸으로
			jtf2.setText("");									//tf2 텍스트를 빈칸으로
		}
	}
	
	class TransActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(check) {											// 만약 check가 true면 실행 : 현재 상태가 원->달러
				String won = jtf1.getText();						// tf1값을 won에 string타입으로 저장
				double dollor = Double.valueOf(won)*1100.0;		// won을 계산을 위해 double로 타입변환 후 *1100.0 하여 저장  
				jtf2.setText(String.valueOf(dollor));			// double형 dollor을 string으로 타입변환 후 tf2에 저장
			}	
			else if(!check) {									// 만약 check가 false라면 조전문 실행
				String dollor = jtf2.getText();					// tf2값을 double에 string타입으로 저장
				double won = Double.valueOf(dollor)/1100.0 ;	// dollor를 계산을 위해 double로 타입변환 후 *1100.0 하여 저장  
				jtf1.setText(String.valueOf(won));				// double형 won을 string으로 타입변환 후 tf1에 저장
			}
			
		}
	}
	
	class TrueActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check = true;											// 전역변수로 check 만든후에 버튼이 눌러지면 true로 변경
		}
	}
	
	class FalseActionListener extends NorthPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check = false;											// 전역변수로 check 만든후에 버튼이 눌러지면 true로 변경
		}
	}
}

