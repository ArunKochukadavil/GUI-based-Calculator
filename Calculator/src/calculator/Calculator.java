/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Arun
 */
public class Calculator extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private final JButton n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,add,sub,mul,div,result,del,clr,deci;
    private final JTextField io;
    private String s="";
    private JFrame self;
    //private ButtonGroup bg;
    public Calculator()
    {
        self=this;
        n1=new JButton("1");n1.addActionListener(this);
        n2=new JButton("2");n2.addActionListener(this);
        n3=new JButton("3");n3.addActionListener(this);
        n4=new JButton("4");n4.addActionListener(this);
        n5=new JButton("5");n5.addActionListener(this);
        n6=new JButton("6");n6.addActionListener(this);
        n7=new JButton("7");n7.addActionListener(this);
        n8=new JButton("8");n8.addActionListener(this);
        n9=new JButton("9");n9.addActionListener(this);
        n0=new JButton("0");n0.addActionListener(this);
        add=new JButton("+");add.addActionListener(this);
        sub=new JButton("-");sub.addActionListener(this);
        mul=new JButton("*");mul.addActionListener(this);
        div=new JButton("/");div.addActionListener(this);
        del=new JButton("delete");del.addActionListener(this);
        clr=new JButton("clear");clr.addActionListener(this);
        result=new JButton("=");result.addActionListener(this);
        deci=new JButton(".");deci.addActionListener(this);
        io=new JTextField();
        io.setHorizontalAlignment(JTextField.RIGHT);
        
        io.setBounds(10, 10, 352, 45);
        n7.setBounds(10, 60, 80, 50);
        n8.setBounds(100, 60, 80, 50);
        n9.setBounds(190, 60, 80, 50);
        div.setBounds(280, 60, 80, 50);
        
        n4.setBounds(10,120,80,50);
        n5.setBounds(100, 120, 80, 50);
        n6.setBounds(190, 120, 80, 50);
        add.setBounds(280, 120, 80, 50);
        
        n1.setBounds(10, 180, 80, 50);
        n2.setBounds(100, 180, 80, 50);
        n3.setBounds(190, 180, 80, 50);
        sub.setBounds(280, 180, 80, 50);
        
        n0.setBounds(10, 240, 80, 50);
        del.setBounds(100, 240, 80, 50);
        clr.setBounds(190, 240, 80, 50);
        mul.setBounds(280, 240, 80, 50);
        deci.setBounds(10, 300, 80, 50);
        result.setBounds(100, 300, 260, 50);
        add(io);
        add(n1);
        add(n2);
        add(n3);
        add(n4);
        add(n5);
        add(n6);
        add(n7);
        add(n8);
        add(n9);
        add(n0);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(del);
        add(clr);
        add(result);
        add(deci);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(385, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
           if(ae.getSource()==n0)
            {   s=s+"0";
                io.setText(s);             
            }
           else if(ae.getSource()==n1)
            {
                s=s+"1";
                io.setText(s);
            }
           else if(ae.getSource()==n2)
            {
                s=s+"2";
                io.setText(s);
            }
           else if(ae.getSource()==n3)
            {
                s=s+"3";
                io.setText(s);
            }
           else if(ae.getSource()==n4)
            {
                s=s+"4";
                io.setText(s);
            }
           else if(ae.getSource()==n5)
            {
                s=s+"5";
                io.setText(s);
            }
           else if(ae.getSource()==n6)
            {
                s=s+"6";
                io.setText(s);
            }
           else if(ae.getSource()==n7)
            {
                s=s+"7";
                io.setText(s);
            }
           else if(ae.getSource()==n8)
            {
                s=s+"8";
                io.setText(s);
            }
           else if(ae.getSource()==n9)
            {
                s=s+"9";
                io.setText(s);
            }
           else if(ae.getSource()==deci)
           {
               s=s+".";
               io.setText(s);
           }
           else if(ae.getSource()==add)
            {
                s=s+"+";
                io.setText(s);
            }
           else if(ae.getSource()==sub)
            {
                s=s+"-";
                io.setText(s);
            } 
           else if(ae.getSource()==mul)
            {
                s=s+"*";
                io.setText(s);
            }
           else if(ae.getSource()==div)
            {
                s=s+"/";
                io.setText(s);
            }
           else if(ae.getSource()==result)
            {
                String temp="";
                try
                {
                    io.setText(Double.parseDouble(s)+"");
                }
                catch(Exception e)
                {
                    try
                    {
                        temp=PostFix.getResult(io.getText());
                        if(temp.equals("java.util.EmptyStackException"))
                        {
                            io.setText("Bad input please press clear to continue");
                            s="";
                        }
                        else
                        {
                            io.setText(temp);
                            s=temp;
                        }
                    }
                    catch(Exception ex)
                    {
                        temp="";
                        s="";
                        io.setText("Bad input");
                    }
                }
                
                
            }
           else if(ae.getSource()==clr)
            {
                s="";
                io.setText(null);
            }
           else if(ae.getSource()==del)
            {
                String temp="";
                for(int i=0;i<io.getText().length()-1;i++)
                {
                    if(i>=0)
                        temp+=s.charAt(i);
                }
                io.setText(temp);
                s=temp;
            }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Calculator c=new Calculator();
        try
        {
            c.setVisible(true);
            c.setResizable(false);
            
        }
        catch(Exception e)
        {
            System.out.println("Bad Operation please press clear");
        }
    }
}
class PostFix {
    public static String getResult(String s) {
        //System.out.println("Entered func");
        Boolean b,repeat=false;
        
        Stack<Character> st=new Stack<Character>();
        StringBuffer sb=new StringBuffer();
        String exp="",res="",n="";
        char c[]=s.toCharArray();
        //for(char c1:c)
            //System.out.println("check : "+c1);
        for(int i=0;i<c.length;i++)
        {
            //System.out.println("Conversion started ");
            if((c[i]>='0' && c[i]<='9' || c[i]=='.') || (i==0 && c[i]=='-'))
            {
                
                int k=i+1;n="";
                n=n+c[i];
                b=false;
                if(k<c.length)
                {
                    //System.out.println("joining started 1");
                    b=true;
                    while((c[k]>='0' && c[k]<='9')|| c[k]=='.')
                    {
                        //System.out.println("joining started 2");
                        if(c[k]=='.')
                        {
                            if(repeat==false)
                            {
                                repeat=true;
                                System.out.println("decimal found");
                            }
                            else
                            {
                                throw new NumberFormatException();
                            }
                        }
                        n=n+c[k];
                        if(++k>=c.length)
                            break;
                    }
                    i=k-1;
                    repeat=false;
                }
                if(b)
                {
                    //System.out.println(n+" done");
                    sb.append(n+" ");
                    b=true;
                }
                else
                {
                    sb.append(n);
                }
            }
            else
            {
                if(st.isEmpty())
                {
                    st.add(c[i]);
                }
                else
                {
                    if(hasPrecedence(c[i],st.peek()))
                    {
                        sb.append(st.pop());
                        if(st.isEmpty()==false)
                            while(getPriority(st.peek())==getPriority(c[i]))
                            {
                                sb.append(st.pop());
                                if(st.isEmpty()==true)
                                    break;
                            }
                        st.push(c[i]);
                    }
                    else if(st.peek()==c[i])
                    {
                        sb.append(st.pop());
                        st.push(c[i]);
                    }   
                    else if(getPriority(st.peek())==getPriority(c[i]))
                    {
                        sb.append(st.pop());
                        st.push(c[i]);
                    }
                    else
                    {
                        st.push(c[i]);        
                    }
                }
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        System.out.println(sb.toString());
        res=evalPostFix(sb);
        return res;
    }

    private static boolean hasPrecedence(char c,Character peek) {
        int c1=getPriority(c);
        int c2=getPriority(peek);
        if(c2>c1)
            return true;
        else
            return false;
    }

    private static int getPriority(Character peek) {
        switch(peek)
        {
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
        }
        return 0;
    }
    
    private static String evalPostFix(StringBuffer sb) {
        Stack<Double> st=new Stack<Double>();
        System.out.println("Entered func");
        String t="";int k=0;
        try
        {
            for(int i=0;i<sb.length();i++)
            {
                //System.out.println("looping : "+sb.charAt(i));
                if(sb.charAt(i)==' ' || (sb.charAt(i)>='0'&& sb.charAt(i)<='9' || sb.charAt(i)=='.'))
                {
                    Boolean len=false,b=false,repeat=false;
                    if(sb.charAt(i)!=' ' && (sb.charAt(i)>='0' && sb.charAt(i)<='9' || sb.charAt(i)=='.'))
                    {
                        t="";
                        t=t+sb.charAt(i);
                        
                        if(sb.charAt(i+1)==' ')
                            k=sb.length();
                        else
                             k=i+1;
                        //System.out.println(sb.charAt(i));
                        if(k<sb.length())
                        {
                            while((sb.charAt(k)>='0' && sb.charAt(k)<='9') || sb.charAt(k)=='.')
                            {
                                if(sb.charAt(i)=='.')
                                {
                                    if(repeat==false)
                                    {
                                        repeat=true;
                                    }
                                    else
                                    {
                                        throw new NumberFormatException();
                                    }
                                }
                                b=true;
                                //System.out.println("t : "+t);
                                t=t+sb.charAt(k);
                                if(++k>=sb.length())
                                    break;
                            }
                            i=k-1;
                            repeat=false;
                        }
                        if(b)
                        {
                            b=false;
                            st.push(Double.parseDouble(t));
                        }
                        else
                        {
                            st.push(Double.parseDouble(t));
                        }
                    }
                        
                    
                }
                else if(sb.charAt(i)!=' ')
                {
                    //System.out.println("Operator group");
                    double c1=st.pop();double c2=st.pop();
                    System.out.println("c2 : "+c2);
                    System.out.println("c1 : "+c1);
                    System.out.println("Op : "+sb.charAt(i));
                    switch(sb.charAt(i))
                    {
                        case '+':st.push(c2+c1);
                                 break;
                        case '-':st.push(c2-c1);                                    
                                 break;
                        case '*':st.push(c2*c1);
                                 break;
                        case '/':st.push(c2/c1);
                                 break;
                    }
                }
            }
            return Double.toString(st.peek());
        }
        catch(Exception e)
        {
            return e.toString();
        }
        
    }
}
