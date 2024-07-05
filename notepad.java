import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class g2 extends JFrame implements ActionListener
{
	JFrame f;
	JTextArea ta;
	JMenuBar mb;
    JMenuItem fitem1,fitem2,fitem3,fitem4,fitem5;
    JMenuItem eitm1,eitm2,eitm3,eitm4;
    JMenu foitem1,foitem2;
    JMenuItem f1,f2,f3,f4,f5;
   // JMenuItem s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    Font bigfont;
	
	public g2()
	{
        f=new JFrame("Notepad");
        ImageIcon img=new ImageIcon("notepad.png");
        f.setIconImage(img.getImage());

        ta=new JTextArea();
        bigfont=new Font("Arial Rounded MT",Font.BOLD,15);
        ta.setFont(bigfont);
        ta.setLineWrap(true);
        ta.setEditable(true);

        mb=new JMenuBar();

        JMenu m1=new JMenu("File");
        JMenu m2=new JMenu("Edit");
        JMenu m3=new JMenu("Font");
        JMenu m4=new JMenu("Find");

     //menu-1 add............

        fitem1=new JMenuItem("New");
        fitem1.addActionListener(this);
        fitem2=new JMenuItem("Open");
        fitem2.addActionListener(this);
        fitem3=new JMenuItem("Save");
        fitem3.addActionListener(this);
        fitem4=new JMenuItem("Print");
        fitem4.addActionListener(this);
        fitem5=new JMenuItem("Exit");
        fitem5.addActionListener(this);

        m1.add(fitem1);
        m1.add(fitem2);
        m1.add(fitem3);
        m1.add(fitem4);
        m1.add(fitem5);

     // menu-2 add..........

        eitm1=new JMenuItem("Selectall");
        eitm1.addActionListener(this);
        eitm2=new JMenuItem("Copy");
        eitm2.addActionListener(this);
        eitm3=new JMenuItem("Paste");
        eitm3.addActionListener(this);
        eitm4=new JMenuItem("Cut");
        eitm4.addActionListener(this);

        m2.add(eitm1);
        m2.add(eitm2);
        m2.add(eitm3);
        m2.add(eitm4);

     // menu-3 add...........

        foitem1=new JMenu("Font-Style");
        foitem2=new JMenu("Font-Size");

        f1=new JMenuItem("Arial");
        f1.addActionListener(this);
        f2=new JMenuItem("Algerian");
        f2.addActionListener(this);
        f3=new JMenuItem("Bell MT");
        f3.addActionListener(this);
        f4=new JMenuItem("Cambria");
        f4.addActionListener(this);
        f5=new JMenuItem("Impact");
        f5.addActionListener(this);

        foitem1.add(f1);
        foitem1.add(f2);
        foitem1.add(f3);
        foitem1.add(f4);
        foitem1.add(f5);

        m3.add(foitem1);
        m3.add(foitem2);

     //menubar -- add all menu in menubar

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);

     //menu -- menubar add in frame

        f.add(mb);
        f.setJMenuBar(mb);
        mb.setBorderPainted(true);
        f.add(ta);

        //f.setLayout(null);
        f.setSize(300,300);
        f.getContentPane().setBackground(Color.white);
        f.setVisible(true);
	}

    public void actionPerformed(ActionEvent ae)
    {
        // file menu

        if(ae.getSource()==fitem1)
        {
            ta.setText("");
        }
        if(ae.getSource()==fitem2)
        {
            JFileChooser obj=new JFileChooser();
            if(obj.showOpenDialog(f)==JFileChooser.APPROVE_OPTION)
            {
                try
                {
                   FileInputStream fis =new FileInputStream(obj.getSelectedFile());
                   BufferedReader br=new BufferedReader(new InputStreamReader(fis));
                   StringBuffer text=new StringBuffer();
                   String read;
                   while((read=br.readLine())!=null)
                   {
                      text.append(read).append("\n"); 
                   }
                   ta.setText(text.toString());
                }
                catch(Exception e)
                {}
            }
        }
        if(ae.getSource()==fitem3)
        {
            JFileChooser fc=new JFileChooser("f:");

            int r= fc.showSaveDialog(null);

            if(r==JFileChooser.APPROVE_OPTION)
            {
                File fi=new File(fc.getSelectedFile().getAbsolutePath());

                try
                {
                    FileWriter fw=new FileWriter(fi,false);
                    BufferedWriter br=new BufferedWriter(fw);

                    br.write(ta.getText());
                    br.flush();
                    br.close();

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(f,e.getMessage());
                }
            }
        }
        if(ae.getSource()==fitem4)
        {
            try
            {
              ta.print();
            }
            catch(Exception e)
            {}
        }
        if(ae.getSource()==fitem5)
        {
            System.exit(0);
        }

        //edit menu
        if(ae.getSource()==eitm1)
        {
            ta.selectAll();
        }
        if(ae.getSource()==eitm2)
        {
            ta.copy();
        }
        if(ae.getSource()==eitm3)
        {
            ta.paste();
        }
        if(ae.getSource()==eitm4)
        {
            ta.cut();
        }

        // font menu

        if(ae.getSource()==f1)
        {
            Font f=new Font("Arial",Font.BOLD,20);
            ta.setFont(f);
        }
        if(ae.getSource()==f2)
        {
            Font f=new Font("Algerian",Font.BOLD,20);
            ta.setFont(f);
        }
        if(ae.getSource()==f3)
        {
            Font f=new Font("Bell MT",Font.PLAIN,20);
            ta.setFont(f);
        }
        if(ae.getSource()==f4)
        {
            Font f=new Font("Cambria",Font.PLAIN,20);
            ta.setFont(f);
        }
        if(ae.getSource()==f5)
        {
            Font f=new Font("Impact",Font.PLAIN,20);
            ta.setFont(f);
        }
    }

   
	public static void main(String args[]) 
	{
		new g2();
	}
}