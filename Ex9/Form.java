import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class Form extends Applet
{
	Frame1  f;
	public void init()
	{

	}
	public void paint(Graphics g)
	{
    	f=new Frame1("Student Login");
  }
}

class Frame1 extends Frame implements ActionListener, FocusListener
{
	boolean name_flag=false,reg_flag=false;
	Button b;
	Label name,reg,gender,degree,branch,year,date,address,email,hobby,extra,enter,status,head;
	TextField t1,t2,t3;
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox cb1,cb2,cb3,cb4,cb5;
	Choice c1,c2,c3,c4,c5,c6;
	TextArea ta1,ta2;
	List l;
	Font myFont = new Font("Segoe UI", Font.PLAIN,14);

	public Frame1(String s)
	{
		super(s);
		setLayout(null);
		setVisible(true);
		setLocation(200,0);
		setSize(900,800);
		setBackground(new Color(240,240,245));

		head=new Label("Student Response Form");add(head);head.setBounds(305,60,300,50);head.setFont(new Font("Segoe UI", Font.BOLD, 22));
    reg=new Label("Register No");add(reg);reg.setBounds(80+20,100+55,100,20);reg.setFont(myFont);
    name=new Label("Name");add(name);name.setBounds(80+20,150+55,100,20);name.setFont(myFont);
		gender=new Label("Gender");add(gender);gender.setBounds(80+20,200+55,100,20);gender.setFont(myFont);
		degree=new Label("Degree");add(degree);degree.setBounds(80+20,250+55,100,20);degree.setFont(myFont);
		branch=new Label("Branch");add(branch);branch.setBounds(80+20,300+55,100,20);branch.setFont(myFont);
		year=new Label("Year");add(year);year.setBounds(80+20,350+55,100,20);year.setFont(myFont);
		date=new Label("D.O.B");add(date);date.setBounds(80+20,400+55,100,20);date.setFont(myFont);
		address=new Label("Address");add(address);address.setBounds(80+20,450+55,100,20);address.setFont(myFont);
		email=new Label("Email");add(email);email.setBounds(80+20,580+55,100,20);email.setFont(myFont);
		hobby=new Label("Hobby");add(hobby);hobby.setBounds(440+20,100+55,100,20);hobby.setFont(myFont);
		extra=new Label("Extra Curricular Activities");add(extra);extra.setBounds(440+20,200+55,300,20);extra.setFont(myFont);
		enter=new Label("You Entered");add(enter);enter.setBounds(440+20,350+55,100,20);enter.setFont(myFont);
		status=new Label("Status");add(status);status.setBounds(100+00,700,200,30);status.setFont(myFont);

		t1=new TextField();add(t1);t1.setBounds(200+20,100+55,120,20);t1.addFocusListener(this);t1.setFont(myFont);
		t2=new TextField();add(t2);t2.setBounds(200+20,150+55,120,20);t2.addFocusListener(this);t2.setFont(myFont);
		t3=new TextField();add(t3);t3.setBounds(200+20,580+55,200,20);t3.addFocusListener(this);t3.setFont(myFont);

		cb1=new Checkbox("Male",cbg,true);add(cb1);cb1.setBounds(200+20,200+55,50,20);cb1.setFont(myFont);
		cb2=new Checkbox("Female",cbg,false);add(cb2);cb2.setBounds(260+20,200+55,80,20);cb2.setFont(myFont);

		cb3=new Checkbox("Stamp Collection",false);add(cb3);cb3.setBounds(440+20,125+55,130,20);cb3.setFont(myFont);
		cb4=new Checkbox("Reading Novels",false);add(cb4);cb4.setBounds(580+20,125+55,130,20);cb4.setFont(myFont);
		cb5=new Checkbox("Drawing",false);add(cb5);cb5.setBounds(710+20,125+55,130,20);cb5.setFont(myFont);

		c1=new Choice();add(c1);c1.setBounds(200+20,250+55,90,20);c1.setFont(myFont);c1.add("B-Tech");c1.add("M-Tech");
  	c2=new Choice();add(c2);c2.setBounds(200+20,300+55,90,20);c2.setFont(myFont);c2.add("CSE");c2.add("ICT");c2.add("IT");c2.add("MECH");c2.add("CIVIL");c2.add("BIOTECH");
		c3=new Choice();add(c3);c3.setBounds(200+20,350+55,50,20);c3.setFont(myFont);c3.add("1");c3.add("2");c3.add("3");c3.add("4");

		c4=new Choice();add(c4);c4.setBounds(200+20,400+55,50,20);c4.setFont(myFont);
		for(int i=1;i<=31;i++)
		{
			c4.add(Integer.toString(i));
		}
		c5=new Choice();add(c5);c5.setBounds(270+20,400+55,50,20);c5.setFont(myFont);
		for(int i=1;i<=12;i++)
		{
			c5.add(Integer.toString(i));
		}
		c6=new Choice();add(c6);c6.setBounds(340+20,400+55,60,20);c6.setFont(myFont);
		for(int i=1980;i<=1999;i++)
		{
			c6.add(Integer.toString(i));
		}

		ta1=new TextArea(200,100);add(ta1);ta1.setBounds(200+20,450+55,200,100);ta1.setFont(myFont);
		ta2=new TextArea(350,300);add(ta2);ta2.setBounds(440+20,375+55,350,225);ta2.setEditable(false);ta2.setFont(myFont);
		l=new List(5,true);add(l);l.setBounds(440+20,225+55,150,100);l.setFont(myFont);l.add("Tennis");l.add("Cricket");l.add("Football");l.add("Basketball");l.add("Handball");l.add("Table Tennis");
		b=new Button("Submit");add(b);b.setBounds(400,730,80,25);b.addActionListener(this);b.setFont(myFont);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			if(name_flag==true && reg_flag==true)
			{
				ta2.setText("");

				ta2.append("The Register Number is "+t1.getText()+" \n\n");
				ta2.append("The Name is "+t2.getText()+" \n\n");

				if(cb1.getState())
				ta2.append("The Gender is "+cb1.getLabel()+" \n\n");
				else
				ta2.append("The Gender is "+cb2.getLabel()+" \n\n");

				ta2.append("Studying In "+c3.getSelectedItem()+" year ");
				ta2.append(c2.getSelectedItem()+" ");
				ta2.append(c1.getSelectedItem()+" \n\n");

				ta2.append("Born On "+c4.getSelectedItem()+"/");
				ta2.append(c5.getSelectedItem()+"/");
				ta2.append(c6.getSelectedItem()+" \n\n");

				ta2.append("Address:\n"+ta1.getText()+" \n\n");
				ta2.append("Email Id is "+t3.getText()+" \n\n");
				ta2.append("Hobbies are \n\n");
				if(cb3.getState())
				{
				  ta2.append("           "+cb3.getLabel()+" \n");
				}
				if(cb4.getState())
				{
				  ta2.append("           "+cb4.getLabel()+" \n");
				}
				if(cb5.getState())
				{
				  ta2.append("           "+cb5.getLabel()+" \n");
				}
				String str[]=new String[5];
				str=l.getSelectedItems();
				ta2.append("\nExtracurricular Activities include\n");
				for(String a2:str)
				{
				  ta2.append("   "+a2+"\n");
				}
			}
			else
			{
				status.setText("Identity Error");
			}
		}
	}

	public void focusGained(FocusEvent fe)
	{

	}

	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==t1)
		{
			String s=t1.getText();
			s=s.replaceAll("[*a-zA-Z]", "");
			t1.setText(s);
			if(s.length()!=9)
			{
				t1.setText("");
				status.setText("9 Digits Required");
				reg_flag=false;
			}
			else
			{
				reg_flag=true;
				status.setText("All Fine");
			}
		}
		else if(fe.getSource()==t2)
		{
			String s=t2.getText();
			if(s.isEmpty())
			{
				name_flag=false;
			}
			else
			{
				s=s.replaceAll("[*0-9]", "");
				t2.setText(s);
				name_flag=true;
			}
		}
	}
}
