import java.applet.*;
import java.awt.event.*;
import java.awt.*;
/*
<applet code = "Calc" width = 1000 height = 1000></applet>
*/
public class Calc extends Applet
{
	Frame1 f;

	public void init()
	{

	}

	public void paint(Graphics g)
	{
		f=new Frame1("Calculator");
	}
}

class Frame1 extends Frame implements ActionListener
{
	Button b[]=new Button[24];
	String name[]={"M+","M-","MC","MR","C","CE","<--","SQRT","1","2","3","+","4","5","6","-","7","8","9","*","0",".","=","/"};
	Panel digit,text;
	TextField t;
	boolean plus,minus,mul,div,first=true,result=false;
	double mem=0.0;

	Frame1(String s)
	{
		super(s);
		setVisible(true);
		setSize(300,400);
		setLocation(200,200);
		setLayout(new BorderLayout(5,5));
		digit=new Panel();
		digit.setLayout(new GridLayout(6,4,5,5));
		text=new Panel();
		add(digit,BorderLayout.SOUTH);
		add(text,BorderLayout.NORTH);
		t=new TextField(30);
		text.add(t);
		t.setEditable(false);

		for(int i=0;i<24;i++)
		{
			b[i]=new Button(name[i]);
			digit.add(b[i]);
			b[i].addActionListener(this);
		}

		plus=minus=mul=div=false;

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(result)
		{
			result=false;
			t.setText("0");
		}
		if(ae.getActionCommand()=="1")
			t.setText(t.getText()+"1");
		if(ae.getActionCommand()=="2")
			t.setText(t.getText()+"2");
		if(ae.getActionCommand()=="3")
			t.setText(t.getText()+"3");
		if(ae.getActionCommand()=="4")
			t.setText(t.getText()+"4");
		if(ae.getActionCommand()=="5")
			t.setText(t.getText()+"5");
		if(ae.getActionCommand()=="6")
			t.setText(t.getText()+"6");
		if(ae.getActionCommand()=="7")
			t.setText(t.getText()+"7");
		if(ae.getActionCommand()=="8")
			t.setText(t.getText()+"8");
		if(ae.getActionCommand()=="9")
			t.setText(t.getText()+"9");
		if(ae.getActionCommand()=="0")
			t.setText(t.getText()+"0");
		if(ae.getActionCommand()==".")
			t.setText(t.getText()+".");

		if(ae.getActionCommand()=="+")
		{
			plus=true;minus=false;mul=false;div=false;
			mem+=Double.parseDouble(t.getText());
			t.setText("");
			first=false;
		}
		if(ae.getActionCommand()=="-")
		{
			plus=false;minus=true;mul=false;div=false;
			if(first)
				mem+=Double.parseDouble(t.getText());
			else
			mem-=Double.parseDouble(t.getText());
			t.setText("");
			first=false;
		}
		if(ae.getActionCommand()=="*")
		{
			plus=false;minus=false;mul=true;div=false;
			if(first)
				mem=Double.parseDouble(t.getText());
			else
				mem*=Double.parseDouble(t.getText());
				first=false;
			t.setText("");
		}
		if(ae.getActionCommand()=="/")
		{
			plus=false;minus=false;mul=false;div=true;
			if(first)
				mem=Double.parseDouble(t.getText());
			else
				mem/=Double.parseDouble(t.getText());
			first=false;
			t.setText("");
		}
		if(ae.getActionCommand()=="=")
		{
			if(plus)
			{
				mem+=Double.parseDouble(t.getText());
				t.setText(""+mem);
				plus=false;result=true;
			}
			if(minus)
			{
				mem-=Double.parseDouble(t.getText());
				t.setText(mem+"");
				minus=false;result=true;
			}
			if(mul)
			{
				mem*=Double.parseDouble(t.getText());
				t.setText(mem+"");
				mul=false;result=true;
			}
			if(div)
			{
				if(t.getText()=="0")
				{
					result=true;
					t.setText("Invalid Number");
				}
				else
				{
					mem/=Double.parseDouble(t.getText());
					t.setText(""+mem);
					div=false;result=true;
				}
			}
		}

		if(ae.getActionCommand()=="C")
			t.setText("");
		if(ae.getActionCommand()=="CE")
		{
			mem=0.0;
			first=true;
			result=false;
			t.setText("");
		}
		if(ae.getActionCommand()=="<--")
		{
			String s=t.getText();
			if(s.length()!=0)
			{
				s=s.substring(0,s.length()-1);
				t.setText(s);
			}
		}
		if(ae.getActionCommand()=="M+")
		{
			mem+=Double.parseDouble(t.getText())+0;
		}
		if(ae.getActionCommand()=="M-")
		{
			mem-=Double.parseDouble(t.getText())+0;
		}
		if(ae.getActionCommand()=="MR")
		{
			t.setText(mem+"");
		}
		if(ae.getActionCommand()=="MC")
		{
			mem=0.0;
			first=true;
		}
		if(ae.getActionCommand()=="SQRT")
		{
			if(Double.parseDouble(t.getText())<0)
			{
				result=true;
				t.setText("Sign Error");
			}
			else
			{
				mem=Math.sqrt(Double.parseDouble(t.getText())+0);
				t.setText(mem+"");
				result=true;
			}
		}
	}
}
