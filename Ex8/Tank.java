import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code=Tank width=600 height=600 ></applet>
*/
public class Tank extends Applet implements Runnable, ActionListener
{
  String msg=" ";
  boolean startFlag;
  boolean suspendFlag;
  Thread t;
  int ht=399;
  int i=0;
  Button star;
  Button stop;
  Button suspend;
  Button resume;

  public void init()
  {
    repaint();
    startFlag = false;
    suspendFlag = false;
    setBackground(Color.white);
    setForeground(Color.blue);
    star = new Button("Start");
    stop = new Button("Stop");
    suspend = new Button("Suspend");
    resume = new Button("Resume");
    add(star);
    add(stop);
    add(suspend);
    add(resume);
    star.addActionListener(this);
    stop.addActionListener(this);
    suspend.addActionListener(this);
    resume.addActionListener(this);
  }

  @Deprecated

  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getSource() == star)
    {
      if (startFlag)
      {
        msg = "Aready Started (1)";
        repaint();
        showStatus("Already Started");
      }
      else
      {
        msg = "Started (1)";
        startFlag = true;
        showStatus("Started");
        t=new Thread(this,"Tank");
        repaint();
        t.start();
      }
    }

    else if (ae.getSource() == stop)
    {
      if (!startFlag)
      {
        msg = "NOT STARTED (1)";
        showStatus("Not Started");
        repaint();
      }
      else
      {
        ht = 399;
        i = 0;
        showStatus("Stopped");
        stop();
        repaint();
      }
    }

    else if (ae.getSource() == suspend)
    {
      if (!startFlag)
      {
        msg = "NOT STARTED";
        repaint();
      }
      else if (!suspendFlag)
      {
        msg = "";
        suspendFlag = true;
        t.suspend();
        showStatus("Suspended");
        repaint();
      }
      else
      {
        showStatus("Already Suspended");
      }
    }

    else if (ae.getSource() == resume)
    {
      if (!startFlag)
      {
        msg = "NOT STARTED";
        repaint();
      }
      else if (suspendFlag)
      {
        msg = "";
        suspendFlag = false;
        showStatus("Resumed");
        t.resume();
        repaint();
      }
      else
      {
        msg = "NOT SUSPENDED";
        repaint();
      }
    }
  }

  public void stop()
  {
    startFlag = false;
    suspendFlag = false;
    t = null;
  }

  public void paint(Graphics g)
  {
    g.setFont(new Font("Segoe UI",0,18 ));
    g.setColor(Color.black);
    g.drawString(msg, 250, 450);
    g.drawLine(200, 400, 200, 100);
    g.drawLine(400, 400, 400, 100);
    g.drawLine(200, 400, 400, 400);

    if(startFlag && !suspendFlag)
    {
      g.setColor(Color.blue);
      g.drawRect(201, ht, 198, i);
      g.fillRect(201, ht, 198, i);
    }
    else if(startFlag && suspendFlag)
    {
      g.setColor(Color.red);
      g.drawRect(201, ht, 198, i);
      g.fillRect(201, ht, 198, i);
    }
  }

  public void run()
  {
    while (startFlag && !suspendFlag)
    {
      repaint();
      try
      {
        t.sleep(400);
        if (ht <= 100)
        {
          msg = "OVERFLOW";
          repaint();
          t.sleep(500);
          msg="";
          ht = 399;
          i = 0;
        }
      }
      catch(Exception e)
      {
        showStatus("InterruptedException");
      }
      ht -= 10;
      i += 10;
    }
  }
}
