import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel tittle_panel=new JPanel();
    JPanel button_Panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;
    int xwins=0, owins=0;
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocation( 400,100);

        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.GREEN);
        textfield.setFont(new Font("Calibari",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0, 10, 500, 50);

        button_Panel.setLayout(new GridLayout(3, 3));
        button_Panel.setBackground(Color.WHITE);

        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("Calibari",Font.BOLD,120));
            buttons[i].setFocusable(false);
        }

        tittle_panel.add(textfield);
        frame.add(tittle_panel,BorderLayout.NORTH);
        frame.add(button_Panel);
        
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        textfield.setFont(new Font("Calibari",Font.BOLD,45));
        textfield.setText("1st turn selection");

        firstTurn();
        textfield.setFont(new Font("Calibari",Font.BOLD,75));
    }

    public void gameOver(String s)
    {
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(n==0)
        {
            frame.dispose();
            new TicTacToe();
        }
        else
        {
            frame.dispose();
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setForeground(Color.BLUE);
                        textfield.setText("O TURN");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setForeground(Color.RED);
                        textfield.setText("X TURN");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            textfield.setForeground(Color.RED);
            textfield.setText("X TURN");
        }
        else
        {
            player1_turn=false;
            textfield.setForeground(Color.BLUE);
            textfield.setText("O TURN");
        }

        for(int i=0;i<9;i++)
        buttons[i].addActionListener(this);

    }

    public void check()
    {
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X")&& (buttons[2].getText()=="X"))
        {
            xWins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[5].getText()=="X"))
        {
            xWins(3, 4, 5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X")&& (buttons[8].getText()=="X"))
        {
            xWins(6, 7, 8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X")&& (buttons[6].getText()=="X"))
        {
            xWins(0, 3, 6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[7].getText()=="X"))
        {
            xWins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X")&& (buttons[8].getText()=="X"))
        {
            xWins(2, 5, 8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[8].getText()=="X"))
        {
            xWins(0, 4, 8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[6].getText()=="X"))
        {
            xWins(2, 4, 6);
        }


        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O")&& (buttons[2].getText()=="O"))
        {
            oWins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[5].getText()=="O"))
        {
            oWins(3, 4, 5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O")&& (buttons[8].getText()=="O"))
        {
            oWins(6, 7, 8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O")&& (buttons[6].getText()=="O"))
        {
            oWins(0, 3, 6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[7].getText()=="O"))
        {
            oWins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O")&& (buttons[8].getText()=="O"))
        {
            oWins(2, 5, 8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[8].getText()=="O"))
        {
            oWins(0, 4, 8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[6].getText()=="O"))
        {
            oWins(2, 4, 6);
        }
        for(int i=0;i<9;i++)
        {
            if(buttons[i].getText()=="")
                break;
            else if(i==8)
            {
                textfield.setForeground(Color.GREEN);
                textfield.setText("NO Wins");
                gameOver("No Wins");
            }
        }
    }

    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setForeground(Color.RED);
        textfield.setText("X WINS");
        gameOver("X Wins");
    }
    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setForeground(Color.BLUE);
        textfield.setText("O WINS");
        gameOver("O Wins");
    }
}
