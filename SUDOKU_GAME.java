
import static java.awt.Color.*;
import java.util.HashMap;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class SUDOKU_GAME extends javax.swing.JFrame {

    
    private String number;
    private boolean globalVar=false;
    private Stack<HashMap<JButton,String>> st = new Stack<HashMap<JButton,String>>();
    
    private String solvedBoard [][] = {
        {"2","9","8","5","1","6","7","3","4"},
        {"4","1","3","2","7","8","5","6","9"},
        {"7","5","6","3","4","9","1","2","8"},
        {"8","2","1","4","3","5","6","9","7"},
        {"5","3","4","6","9","7","2","8","1"},
        {"9","6","7","1","8","2","3","4","5"},
        {"1","4","2","8","5","3","9","7","6"},
        {"3","7","5","9","6","4","8","1","2"},
        {"6","8","9","7","2","1","4","5","3"}
    };
    
    public SUDOKU_GAME() {
        initComponents();
        
    }
    
    private void Undo(){
        if(st.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter a value first before using the undo funtionality","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
            
        }else{
            HashMap<JButton,String> deleted = st.pop();
            HashMap.Entry<JButton,String> entry = deleted.entrySet().stream().findFirst().get();
            JButton deletedBtn = entry.getKey();
            boolean flag = false;
            
            Stack<HashMap<JButton,String>> tempst = new  Stack<HashMap<JButton,String>>();
            
            while(!st.isEmpty()){
                
                HashMap<JButton,String> temp = st.pop();
                tempst.push(temp);
                
                HashMap.Entry<JButton,String> entry1 = temp.entrySet().stream().findFirst().get();
                JButton comparedBtn = entry1.getKey();
                String value = entry1.getValue();
                
                if(deletedBtn == comparedBtn){
                    flag = true;
                    comparedBtn.setText(value);
                    break;
                }
            }
            if(flag==false){
                deletedBtn.setText("");
            }
            while(!tempst.isEmpty()){
                HashMap<JButton,String> temp = tempst.pop();
                st.push(temp);
            }
        }
    }
    
    public void chooseNumber(JButton btn)
    {
        selectionbtn1.setBackground(black);
        selectionbtn2.setBackground(black);
        selectionbtn3.setBackground(black);
        selectionbtn4.setBackground(black);
        selectionbtn5.setBackground(black);
        selectionbtn6.setBackground(black);
        selectionbtn7.setBackground(black);
        selectionbtn8.setBackground(black);
        selectionbtn9.setBackground(black);
        
        btn.setBackground(blue);
    }

    public void seeSolution(){
        
        JButton predefinedBtns []={r2c1,r3c1,r3c3,r1c4,r2c5,r2c6,r3c5,r1c7,r1c8,r1c9,r2c7,r2c9,r3c8,r5c2,r5c3,r6c2,r4c5,r4c6,r6c4,r6c5,r4c8,r5c8,r5c7,r7c2,r8c1,r9c1,r9c2,r9c3,r7c5,r8c5,r9c6,r8c4,r7c7,r7c9,r8c9};
        
        JButton btns [][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                boolean flag=true;
                
                for(int k=0;k<predefinedBtns.length;k++)
                {
                    if(predefinedBtns[k] == btns[i][j]){
                        flag=false;
                        break;
                    }
                }
                
                if(flag==true){
                    if(globalVar == false){
                         btns[i][j].setText(solvedBoard[i][j]);
                         btns[i][j].setBackground(black);
                         btns[i][j].setForeground(white);
                    }else{
                        
                         btns[i][j].setText("");
                         btns[i][j].setBackground(white);
                         btns[i][j].setForeground(black);
                        
                    }
                }
            }
        }
        if(globalVar==false){
            
            globalVar=true;
            solutionbtn.setText("HIDE SOLN");
            
        }else{
            globalVar=false;
            solutionbtn.setText("SOLUTION");
        }
    }
    
    private void CheckMoves(){
        JButton btns [][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(btns[i][j].getText()!=solvedBoard[i][j] && btns[i][j].getText()!=""){
                    btns[i][j].setBackground(red);
                }
            }
        }
    } 
    
    public void undoOptn(){
        
    }
    
    public void reset(){
        
         JButton predefinedBtns []={r2c1,r3c1,r3c3,r1c4,r2c5,r2c6,r3c5,r1c7,r1c8,r1c9,r2c7,r2c9,r3c8,r5c2,r5c3,r6c2,r4c5,r4c6,r6c4,r6c5,r4c8,r5c8,r5c7,r7c2,r8c1,r9c1,r9c2,r9c3,r7c5,r8c5,r9c6,r8c4,r7c7,r7c9,r8c9};
        
        JButton btns [][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                boolean flag=true;
                
                for(int k=0;k<predefinedBtns.length;k++)
                {
                    if(predefinedBtns[k] == btns[i][j]){
                        flag=false;
                        break;
                    }
                }
                
                if(flag==true){
                    if(globalVar != false){
                         btns[i][j].setText("");
                         btns[i][j].setBackground(white);
                         btns[i][j].setForeground(white);
                    }else{
                        
                         btns[i][j].setText("");
                         btns[i][j].setBackground(white);
                         btns[i][j].setForeground(black);
                        
                    }
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        r4c8 = new javax.swing.JButton();
        r4c9 = new javax.swing.JButton();
        r4c7 = new javax.swing.JButton();
        r5c7 = new javax.swing.JButton();
        r5c8 = new javax.swing.JButton();
        r5c9 = new javax.swing.JButton();
        r6c7 = new javax.swing.JButton();
        r6c8 = new javax.swing.JButton();
        r6c9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        r4c2 = new javax.swing.JButton();
        r4c3 = new javax.swing.JButton();
        r4c1 = new javax.swing.JButton();
        r5c1 = new javax.swing.JButton();
        r5c2 = new javax.swing.JButton();
        r5c3 = new javax.swing.JButton();
        r6c1 = new javax.swing.JButton();
        r6c2 = new javax.swing.JButton();
        r6c3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        r4c5 = new javax.swing.JButton();
        r4c6 = new javax.swing.JButton();
        r4c4 = new javax.swing.JButton();
        r5c4 = new javax.swing.JButton();
        r5c5 = new javax.swing.JButton();
        r5c6 = new javax.swing.JButton();
        r6c4 = new javax.swing.JButton();
        r6c5 = new javax.swing.JButton();
        r6c6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        r1c5 = new javax.swing.JButton();
        r1c6 = new javax.swing.JButton();
        r1c4 = new javax.swing.JButton();
        r2c4 = new javax.swing.JButton();
        r2c5 = new javax.swing.JButton();
        r2c6 = new javax.swing.JButton();
        r3c4 = new javax.swing.JButton();
        r3c5 = new javax.swing.JButton();
        r3c6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        r1c8 = new javax.swing.JButton();
        r1c9 = new javax.swing.JButton();
        r1c7 = new javax.swing.JButton();
        r2c7 = new javax.swing.JButton();
        r2c8 = new javax.swing.JButton();
        r2c9 = new javax.swing.JButton();
        r3c7 = new javax.swing.JButton();
        r3c8 = new javax.swing.JButton();
        r3c9 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        r1c2 = new javax.swing.JButton();
        r1c3 = new javax.swing.JButton();
        r1c1 = new javax.swing.JButton();
        r2c1 = new javax.swing.JButton();
        r2c2 = new javax.swing.JButton();
        r2c3 = new javax.swing.JButton();
        r3c1 = new javax.swing.JButton();
        r3c2 = new javax.swing.JButton();
        r3c3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        r7c2 = new javax.swing.JButton();
        r7c3 = new javax.swing.JButton();
        r7c1 = new javax.swing.JButton();
        r8c1 = new javax.swing.JButton();
        r8c2 = new javax.swing.JButton();
        r8c3 = new javax.swing.JButton();
        r9c1 = new javax.swing.JButton();
        r9c2 = new javax.swing.JButton();
        r9c3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        r7c5 = new javax.swing.JButton();
        r7c6 = new javax.swing.JButton();
        r7c4 = new javax.swing.JButton();
        r8c4 = new javax.swing.JButton();
        r8c5 = new javax.swing.JButton();
        r8c6 = new javax.swing.JButton();
        r9c4 = new javax.swing.JButton();
        r9c5 = new javax.swing.JButton();
        r9c6 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jButton100 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        r7c8 = new javax.swing.JButton();
        r7c9 = new javax.swing.JButton();
        r7c7 = new javax.swing.JButton();
        r8c7 = new javax.swing.JButton();
        r8c8 = new javax.swing.JButton();
        r8c9 = new javax.swing.JButton();
        r9c7 = new javax.swing.JButton();
        r9c8 = new javax.swing.JButton();
        r9c9 = new javax.swing.JButton();
        selectionbtn1 = new javax.swing.JButton();
        selectionbtn2 = new javax.swing.JButton();
        selectionbtn3 = new javax.swing.JButton();
        selectionbtn4 = new javax.swing.JButton();
        selectionbtn5 = new javax.swing.JButton();
        selectionbtn6 = new javax.swing.JButton();
        selectionbtn7 = new javax.swing.JButton();
        selectionbtn8 = new javax.swing.JButton();
        selectionbtn9 = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        undobtn = new javax.swing.JButton();
        solutionbtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUDOKU GAME");
        setBackground(new java.awt.Color(153, 255, 51));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUDOKU PUZZLE GAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(146, 146));

        r4c8.setBackground(new java.awt.Color(51, 255, 255));
        r4c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c8.setText("9");
        r4c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c8ActionPerformed(evt);
            }
        });

        r4c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c9ActionPerformed(evt);
            }
        });

        r4c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c7ActionPerformed(evt);
            }
        });

        r5c7.setBackground(new java.awt.Color(51, 255, 255));
        r5c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c7.setText("2");
        r5c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c7ActionPerformed(evt);
            }
        });

        r5c8.setBackground(new java.awt.Color(51, 255, 255));
        r5c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c8.setText("8");
        r5c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c8ActionPerformed(evt);
            }
        });

        r5c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c9ActionPerformed(evt);
            }
        });

        r6c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c7ActionPerformed(evt);
            }
        });

        r6c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c8ActionPerformed(evt);
            }
        });

        r6c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(146, 146));

        r4c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c2ActionPerformed(evt);
            }
        });

        r4c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c3ActionPerformed(evt);
            }
        });

        r4c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c1ActionPerformed(evt);
            }
        });

        r5c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c1ActionPerformed(evt);
            }
        });

        r5c2.setBackground(new java.awt.Color(51, 255, 255));
        r5c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c2.setText("3");
        r5c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c2ActionPerformed(evt);
            }
        });

        r5c3.setBackground(new java.awt.Color(51, 255, 255));
        r5c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c3.setText("4");
        r5c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c3ActionPerformed(evt);
            }
        });

        r6c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c1ActionPerformed(evt);
            }
        });

        r6c2.setBackground(new java.awt.Color(51, 255, 255));
        r6c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c2.setText("6");
        r6c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c2ActionPerformed(evt);
            }
        });

        r6c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(146, 146));

        r4c5.setBackground(new java.awt.Color(51, 255, 255));
        r4c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c5.setText("3");
        r4c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c5ActionPerformed(evt);
            }
        });

        r4c6.setBackground(new java.awt.Color(51, 255, 255));
        r4c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c6.setText("5");
        r4c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c6ActionPerformed(evt);
            }
        });

        r4c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c4ActionPerformed(evt);
            }
        });

        r5c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c4ActionPerformed(evt);
            }
        });

        r5c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c5ActionPerformed(evt);
            }
        });

        r5c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c6ActionPerformed(evt);
            }
        });

        r6c4.setBackground(new java.awt.Color(51, 255, 255));
        r6c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c4.setText("1");
        r6c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c4ActionPerformed(evt);
            }
        });

        r6c5.setBackground(new java.awt.Color(51, 255, 255));
        r6c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c5.setText("8");
        r6c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c5ActionPerformed(evt);
            }
        });

        r6c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(146, 146));

        r1c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c5ActionPerformed(evt);
            }
        });

        r1c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c6ActionPerformed(evt);
            }
        });

        r1c4.setBackground(new java.awt.Color(51, 255, 255));
        r1c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c4.setText("5");
        r1c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c4ActionPerformed(evt);
            }
        });

        r2c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c4ActionPerformed(evt);
            }
        });

        r2c5.setBackground(new java.awt.Color(51, 255, 255));
        r2c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c5.setText("7");
        r2c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c5ActionPerformed(evt);
            }
        });

        r2c6.setBackground(new java.awt.Color(51, 255, 255));
        r2c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c6.setText("8");
        r2c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c6ActionPerformed(evt);
            }
        });

        r3c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c4ActionPerformed(evt);
            }
        });

        r3c5.setBackground(new java.awt.Color(51, 255, 255));
        r3c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c5.setText("4");
        r3c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c5ActionPerformed(evt);
            }
        });

        r3c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(146, 146));

        r1c8.setBackground(new java.awt.Color(51, 255, 255));
        r1c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c8.setText("3");
        r1c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c8ActionPerformed(evt);
            }
        });

        r1c9.setBackground(new java.awt.Color(51, 255, 255));
        r1c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c9.setText("4");
        r1c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c9ActionPerformed(evt);
            }
        });

        r1c7.setBackground(new java.awt.Color(51, 255, 255));
        r1c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c7.setText("7");
        r1c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c7ActionPerformed(evt);
            }
        });

        r2c7.setBackground(new java.awt.Color(51, 255, 255));
        r2c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c7.setText("5");
        r2c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c7ActionPerformed(evt);
            }
        });

        r2c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c8ActionPerformed(evt);
            }
        });

        r2c9.setBackground(new java.awt.Color(51, 255, 255));
        r2c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c9.setText("9");
        r2c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c9ActionPerformed(evt);
            }
        });

        r3c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c7ActionPerformed(evt);
            }
        });

        r3c8.setBackground(new java.awt.Color(51, 255, 255));
        r3c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c8.setText("2");
        r3c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c8ActionPerformed(evt);
            }
        });

        r3c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(146, 146));

        r1c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c2ActionPerformed(evt);
            }
        });

        r1c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c3ActionPerformed(evt);
            }
        });

        r1c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c1ActionPerformed(evt);
            }
        });

        r2c1.setBackground(new java.awt.Color(51, 255, 255));
        r2c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c1.setText("4");
        r2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c1ActionPerformed(evt);
            }
        });

        r2c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c2ActionPerformed(evt);
            }
        });

        r2c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c3ActionPerformed(evt);
            }
        });

        r3c1.setBackground(new java.awt.Color(51, 255, 255));
        r3c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c1.setText("7");
        r3c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c1ActionPerformed(evt);
            }
        });

        r3c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c2ActionPerformed(evt);
            }
        });

        r3c3.setBackground(new java.awt.Color(51, 255, 255));
        r3c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c3.setText("6");
        r3c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setPreferredSize(new java.awt.Dimension(146, 146));

        r7c2.setBackground(new java.awt.Color(51, 255, 255));
        r7c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c2.setText("4");
        r7c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c2ActionPerformed(evt);
            }
        });

        r7c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c3ActionPerformed(evt);
            }
        });

        r7c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c1ActionPerformed(evt);
            }
        });

        r8c1.setBackground(new java.awt.Color(51, 255, 255));
        r8c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c1.setText("3");
        r8c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c1ActionPerformed(evt);
            }
        });

        r8c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c2ActionPerformed(evt);
            }
        });

        r8c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c3ActionPerformed(evt);
            }
        });

        r9c1.setBackground(new java.awt.Color(51, 255, 255));
        r9c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c1.setText("6");
        r9c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c1ActionPerformed(evt);
            }
        });

        r9c2.setBackground(new java.awt.Color(51, 255, 255));
        r9c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c2.setText("8");
        r9c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c2ActionPerformed(evt);
            }
        });

        r9c3.setBackground(new java.awt.Color(51, 255, 255));
        r9c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c3.setText("9");
        r9c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(146, 146));

        r7c5.setBackground(new java.awt.Color(51, 255, 255));
        r7c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c5.setText("5");
        r7c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c5ActionPerformed(evt);
            }
        });

        r7c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c6ActionPerformed(evt);
            }
        });

        r7c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c4ActionPerformed(evt);
            }
        });

        r8c4.setBackground(new java.awt.Color(51, 255, 255));
        r8c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c4.setText("9");
        r8c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c4ActionPerformed(evt);
            }
        });

        r8c5.setBackground(new java.awt.Color(51, 255, 255));
        r8c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c5.setText("6");
        r8c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c5ActionPerformed(evt);
            }
        });

        r8c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c6ActionPerformed(evt);
            }
        });

        r9c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c4ActionPerformed(evt);
            }
        });

        r9c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c5ActionPerformed(evt);
            }
        });

        r9c6.setBackground(new java.awt.Color(51, 255, 255));
        r9c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c6.setText("1");
        r9c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c6ActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setPreferredSize(new java.awt.Dimension(146, 146));

        jButton100.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton100ActionPerformed(evt);
            }
        });

        jButton101.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton101ActionPerformed(evt);
            }
        });

        jButton102.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton102ActionPerformed(evt);
            }
        });

        jButton103.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton103ActionPerformed(evt);
            }
        });

        jButton104.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton104ActionPerformed(evt);
            }
        });

        jButton105.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton105ActionPerformed(evt);
            }
        });

        jButton106.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton106ActionPerformed(evt);
            }
        });

        jButton107.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton107ActionPerformed(evt);
            }
        });

        jButton108.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton108ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setPreferredSize(new java.awt.Dimension(146, 146));

        r7c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c8ActionPerformed(evt);
            }
        });

        r7c9.setBackground(new java.awt.Color(51, 255, 255));
        r7c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c9.setText("6");
        r7c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c9ActionPerformed(evt);
            }
        });

        r7c7.setBackground(new java.awt.Color(51, 255, 255));
        r7c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c7.setText("9");
        r7c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c7ActionPerformed(evt);
            }
        });

        r8c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c7ActionPerformed(evt);
            }
        });

        r8c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c8ActionPerformed(evt);
            }
        });

        r8c9.setBackground(new java.awt.Color(51, 255, 255));
        r8c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c9.setText("2");
        r8c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c9ActionPerformed(evt);
            }
        });

        r9c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c7ActionPerformed(evt);
            }
        });

        r9c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c8ActionPerformed(evt);
            }
        });

        r9c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        selectionbtn1.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn1.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn1.setText("1");
        selectionbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn1ActionPerformed(evt);
            }
        });

        selectionbtn2.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn2.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn2.setText("2");
        selectionbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn2ActionPerformed(evt);
            }
        });

        selectionbtn3.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn3.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn3.setText("3");
        selectionbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn3ActionPerformed(evt);
            }
        });

        selectionbtn4.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn4.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn4.setText("4");
        selectionbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn4ActionPerformed(evt);
            }
        });

        selectionbtn5.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn5.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn5.setText("5");
        selectionbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn5ActionPerformed(evt);
            }
        });

        selectionbtn6.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn6.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn6.setText("6");
        selectionbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn6ActionPerformed(evt);
            }
        });

        selectionbtn7.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn7.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn7.setText("7");
        selectionbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn7ActionPerformed(evt);
            }
        });

        selectionbtn8.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn8.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn8.setText("8");
        selectionbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn8ActionPerformed(evt);
            }
        });

        selectionbtn9.setBackground(new java.awt.Color(0, 0, 0));
        selectionbtn9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        selectionbtn9.setForeground(new java.awt.Color(255, 255, 255));
        selectionbtn9.setText("9");
        selectionbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionbtn9ActionPerformed(evt);
            }
        });

        resetbtn.setBackground(new java.awt.Color(51, 255, 0));
        resetbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        undobtn.setBackground(new java.awt.Color(51, 51, 255));
        undobtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        undobtn.setText("UNDO");
        undobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undobtnActionPerformed(evt);
            }
        });

        solutionbtn.setBackground(new java.awt.Color(255, 255, 0));
        solutionbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        solutionbtn.setText("SOLUTION");
        solutionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionbtnActionPerformed(evt);
            }
        });

        checkbtn.setBackground(new java.awt.Color(255, 102, 0));
        checkbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        checkbtn.setText("CHECK MOVES");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtnActionPerformed(evt);
            }
        });

        exitbtn.setBackground(new java.awt.Color(255, 0, 0));
        exitbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        exitbtn.setText("EXIT");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetbtn)
                        .addGap(81, 81, 81)
                        .addComponent(undobtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitbtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(checkbtn)
                            .addGap(41, 41, 41)
                            .addComponent(solutionbtn)
                            .addGap(22, 22, 22))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(selectionbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetbtn)
                    .addComponent(undobtn)
                    .addComponent(exitbtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkbtn)
                    .addComponent(solutionbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void r4c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c2ActionPerformed
        
        r4c2.setBackground(white);
        r4c2.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c2,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r4c2ActionPerformed

    private void r4c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c3ActionPerformed
        
        r4c3.setBackground(white);
        r4c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r4c3ActionPerformed

    private void r4c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c1ActionPerformed
        
        r4c1.setBackground(white);
        r4c1.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c1,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r4c1ActionPerformed

    private void r5c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c1ActionPerformed
        
        r5c1.setBackground(white);
        r5c1.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r5c1,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r5c1ActionPerformed

    private void r5c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c2ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r5c2ActionPerformed

    private void r5c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c3ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r5c3ActionPerformed

    private void r6c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c1ActionPerformed
        
        r6c1.setBackground(white);
        r6c1.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c1,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c1ActionPerformed

    private void r6c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c2ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r6c2ActionPerformed

    private void r6c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c3ActionPerformed
        
        r6c3.setBackground(white);
        r6c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c3ActionPerformed

    private void r4c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r4c5ActionPerformed

    private void r4c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c6ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r4c6ActionPerformed

    private void r4c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c4ActionPerformed
       
        r4c4.setBackground(white);
        r4c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c4,number);
        
        st.push(hm);
    }//GEN-LAST:event_r4c4ActionPerformed

    private void r5c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c4ActionPerformed
        r5c4.setBackground(white);
        r5c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r5c4,number);
        
        st.push(hm);
    }//GEN-LAST:event_r5c4ActionPerformed

    private void r5c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c5ActionPerformed
       
        r5c5.setBackground(white);
        r5c5.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r5c5,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r5c5ActionPerformed

    private void r5c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c6ActionPerformed
        
        r5c6.setBackground(white);
        r5c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r5c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r5c6ActionPerformed

    private void r6c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c4ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r6c4ActionPerformed

    private void r6c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r6c5ActionPerformed

    private void r6c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c6ActionPerformed
        
        r6c6.setBackground(white);
        r6c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c6ActionPerformed

    private void r4c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c8ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r4c8ActionPerformed

    private void r4c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c9ActionPerformed
        
        r4c9.setBackground(white);
        r4c9.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c9,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r4c9ActionPerformed

    private void r4c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c7ActionPerformed
        
        r4c7.setBackground(white);
        r4c7.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r4c7,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r4c7ActionPerformed

    private void r5c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c7ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r5c7ActionPerformed

    private void r5c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c8ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r5c8ActionPerformed

    private void r5c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c9ActionPerformed
        
        r5c9.setBackground(white);
        r5c9.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r5c9,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r5c9ActionPerformed

    private void r6c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c7ActionPerformed
        
        r6c7.setBackground(white);
        r6c7.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c7,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c7ActionPerformed

    private void r6c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c8ActionPerformed
        
        r6c8.setBackground(white);
        r6c8.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c8,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c8ActionPerformed

    private void r6c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c9ActionPerformed
        
        r6c9.setBackground(white);
        r6c9.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r6c9,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r6c9ActionPerformed

    private void r1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c2ActionPerformed
        
        r1c2.setBackground(white);
        r1c2.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r1c2,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r1c2ActionPerformed

    private void r1c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c3ActionPerformed
        
        r1c3.setBackground(white);
        r1c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r1c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r1c3ActionPerformed

    private void r1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c1ActionPerformed
        
        r1c1.setBackground(white);
        r1c1.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r1c1,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r1c1ActionPerformed

    private void r2c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c1ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r2c1ActionPerformed

    private void r2c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c2ActionPerformed
        
        r2c2.setBackground(white);
        r2c2.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r2c2,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r2c2ActionPerformed

    private void r2c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c3ActionPerformed
        
        r2c3.setBackground(white);
        r2c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r2c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r2c3ActionPerformed

    private void r3c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c1ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r3c1ActionPerformed

    private void r3c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c2ActionPerformed
        
        r3c2.setBackground(white);
        r3c2.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r3c2,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r3c2ActionPerformed

    private void r3c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c3ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r3c3ActionPerformed

    private void r1c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c5ActionPerformed
        
        r1c5.setBackground(white);
        r1c5.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r1c5,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r1c5ActionPerformed

    private void r1c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c6ActionPerformed
        
        r1c6.setBackground(white);
        r1c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r1c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r1c6ActionPerformed

    private void r1c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c4ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r1c4ActionPerformed

    private void r2c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c4ActionPerformed
        
        r2c4.setBackground(white);
        r2c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r2c4,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r2c4ActionPerformed

    private void r2c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r2c5ActionPerformed

    private void r2c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c6ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r2c6ActionPerformed

    private void r3c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c4ActionPerformed
        
        r3c4.setBackground(white);
        r3c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r3c4,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r3c4ActionPerformed

    private void r3c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r3c5ActionPerformed

    private void r3c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c6ActionPerformed
        
        r3c6.setBackground(white);
        r3c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r3c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r3c6ActionPerformed

    private void r1c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c8ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r1c8ActionPerformed

    private void r1c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c9ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r1c9ActionPerformed

    private void r1c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c7ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r1c7ActionPerformed

    private void r2c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c7ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r2c7ActionPerformed

    private void r2c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c8ActionPerformed
        
        r2c8.setBackground(white);
        r2c8.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r2c8,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r2c8ActionPerformed

    private void r2c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c9ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r2c9ActionPerformed

    private void r3c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c7ActionPerformed
        
        r3c7.setBackground(white);
        r3c7.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r3c7,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r3c7ActionPerformed

    private void r3c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c8ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r3c8ActionPerformed

    private void r3c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c9ActionPerformed
        
        r3c9.setBackground(white);
        r3c9.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r3c9,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r3c9ActionPerformed

    private void r7c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c2ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r7c2ActionPerformed

    private void r7c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c3ActionPerformed
        
        r7c3.setBackground(white);
        r7c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r7c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r7c3ActionPerformed

    private void r7c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c1ActionPerformed
        
        r7c1.setBackground(white);
        r7c1.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r7c1,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r7c1ActionPerformed

    private void r8c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c1ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r8c1ActionPerformed

    private void r8c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c2ActionPerformed
        
        r8c2.setBackground(white);
        r8c2.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r8c2,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r8c2ActionPerformed

    private void r8c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c3ActionPerformed
        
        r8c3.setBackground(white);
        r8c3.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r8c3,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r8c3ActionPerformed

    private void r9c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c1ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r9c1ActionPerformed

    private void r9c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c2ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r9c2ActionPerformed

    private void r9c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c3ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r9c3ActionPerformed

    private void r7c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r7c5ActionPerformed

    private void r7c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c6ActionPerformed
        
        r7c6.setBackground(white);
        r7c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r7c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r7c6ActionPerformed

    private void r7c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c4ActionPerformed
        
        r7c4.setBackground(white);
        r7c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r7c4,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r7c4ActionPerformed

    private void r8c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c4ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r8c4ActionPerformed

    private void r8c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c5ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r8c5ActionPerformed

    private void r8c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c6ActionPerformed
        
        r8c6.setBackground(white);
        r8c6.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r8c6,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r8c6ActionPerformed

    private void r9c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c4ActionPerformed
        
        r9c4.setBackground(white);
        r9c4.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r9c4,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r9c4ActionPerformed

    private void r9c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c5ActionPerformed
        
        r9c5.setBackground(white);
        r9c5.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r9c5,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r9c5ActionPerformed

    private void r9c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c6ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r9c6ActionPerformed

    private void jButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton100ActionPerformed

    private void jButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton101ActionPerformed

    private void jButton102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton102ActionPerformed

    private void jButton103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton103ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton103ActionPerformed

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton104ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton104ActionPerformed

    private void jButton105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton105ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton105ActionPerformed

    private void jButton106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton106ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton106ActionPerformed

    private void jButton107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton107ActionPerformed

    private void jButton108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton108ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton108ActionPerformed

    private void r7c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c8ActionPerformed
        
        r7c8.setBackground(white);
        r7c8.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r7c8,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r7c8ActionPerformed

    private void r7c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c9ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r7c9ActionPerformed

    private void r7c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c7ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r7c7ActionPerformed

    private void r8c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c7ActionPerformed
        
        r8c7.setBackground(white);
        r8c7.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r8c7,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r8c7ActionPerformed

    private void r8c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c8ActionPerformed
        
        r8c8.setBackground(white);
        r8c8.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r8c8,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r8c8ActionPerformed

    private void r8c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c9ActionPerformed
        
        JOptionPane.showMessageDialog(this,"This Place is already been allocated","SUdoku game",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_r8c9ActionPerformed

    private void r9c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c7ActionPerformed
        
        r9c7.setBackground(white);
        r9c7.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r9c7,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r9c7ActionPerformed

    private void r9c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c8ActionPerformed
        
        r9c8.setBackground(white);
        r9c8.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r9c8,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r9c8ActionPerformed

    private void r9c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r9c9ActionPerformed
        
        r9c9.setBackground(white);
        r9c9.setText(number);
        HashMap<JButton,String> hm=new HashMap<JButton,String>();
        hm.put(r9c9,number);
        
        st.push(hm);
        
    }//GEN-LAST:event_r9c9ActionPerformed

    private void selectionbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn1ActionPerformed
        
        number="1";
        chooseNumber(selectionbtn1);
        
    }//GEN-LAST:event_selectionbtn1ActionPerformed

    private void selectionbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn2ActionPerformed
        
        number="2";
        chooseNumber(selectionbtn2);
        
    }//GEN-LAST:event_selectionbtn2ActionPerformed

    private void selectionbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn3ActionPerformed
        
         number="3";
        chooseNumber(selectionbtn3);
        
    }//GEN-LAST:event_selectionbtn3ActionPerformed

    private void selectionbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn4ActionPerformed
        
         number="4";
        chooseNumber(selectionbtn4);
        
    }//GEN-LAST:event_selectionbtn4ActionPerformed

    private void selectionbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn5ActionPerformed
        
         number="5";
        chooseNumber(selectionbtn5);
        
    }//GEN-LAST:event_selectionbtn5ActionPerformed

    private void selectionbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn6ActionPerformed
        
         number="6";
        chooseNumber(selectionbtn6);
        
    }//GEN-LAST:event_selectionbtn6ActionPerformed

    private void selectionbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn7ActionPerformed
        
         number="7";
        chooseNumber(selectionbtn7);
        
    }//GEN-LAST:event_selectionbtn7ActionPerformed

    private void selectionbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn8ActionPerformed
        
         number="8";
        chooseNumber(selectionbtn8);
        
    }//GEN-LAST:event_selectionbtn8ActionPerformed

    private void selectionbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionbtn9ActionPerformed
        
         number="9";
        chooseNumber(selectionbtn9);
        
    }//GEN-LAST:event_selectionbtn9ActionPerformed

    private void undobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undobtnActionPerformed
        // TODO add your handling code here:
        Undo();
    }//GEN-LAST:event_undobtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        
        
        if(JOptionPane.showConfirmDialog(this,"Confirm if you want to Exit...","Sudoku",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            
            System.exit(0);
        }
        
    }//GEN-LAST:event_exitbtnActionPerformed

    private void solutionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionbtnActionPerformed
        
        seeSolution();
        
    }//GEN-LAST:event_solutionbtnActionPerformed

    private void checkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtnActionPerformed
        
        CheckMoves();
        
    }//GEN-LAST:event_checkbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUDOKU_GAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkbtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton r1c1;
    private javax.swing.JButton r1c2;
    private javax.swing.JButton r1c3;
    private javax.swing.JButton r1c4;
    private javax.swing.JButton r1c5;
    private javax.swing.JButton r1c6;
    private javax.swing.JButton r1c7;
    private javax.swing.JButton r1c8;
    private javax.swing.JButton r1c9;
    private javax.swing.JButton r2c1;
    private javax.swing.JButton r2c2;
    private javax.swing.JButton r2c3;
    private javax.swing.JButton r2c4;
    private javax.swing.JButton r2c5;
    private javax.swing.JButton r2c6;
    private javax.swing.JButton r2c7;
    private javax.swing.JButton r2c8;
    private javax.swing.JButton r2c9;
    private javax.swing.JButton r3c1;
    private javax.swing.JButton r3c2;
    private javax.swing.JButton r3c3;
    private javax.swing.JButton r3c4;
    private javax.swing.JButton r3c5;
    private javax.swing.JButton r3c6;
    private javax.swing.JButton r3c7;
    private javax.swing.JButton r3c8;
    private javax.swing.JButton r3c9;
    private javax.swing.JButton r4c1;
    private javax.swing.JButton r4c2;
    private javax.swing.JButton r4c3;
    private javax.swing.JButton r4c4;
    private javax.swing.JButton r4c5;
    private javax.swing.JButton r4c6;
    private javax.swing.JButton r4c7;
    private javax.swing.JButton r4c8;
    private javax.swing.JButton r4c9;
    private javax.swing.JButton r5c1;
    private javax.swing.JButton r5c2;
    private javax.swing.JButton r5c3;
    private javax.swing.JButton r5c4;
    private javax.swing.JButton r5c5;
    private javax.swing.JButton r5c6;
    private javax.swing.JButton r5c7;
    private javax.swing.JButton r5c8;
    private javax.swing.JButton r5c9;
    private javax.swing.JButton r6c1;
    private javax.swing.JButton r6c2;
    private javax.swing.JButton r6c3;
    private javax.swing.JButton r6c4;
    private javax.swing.JButton r6c5;
    private javax.swing.JButton r6c6;
    private javax.swing.JButton r6c7;
    private javax.swing.JButton r6c8;
    private javax.swing.JButton r6c9;
    private javax.swing.JButton r7c1;
    private javax.swing.JButton r7c2;
    private javax.swing.JButton r7c3;
    private javax.swing.JButton r7c4;
    private javax.swing.JButton r7c5;
    private javax.swing.JButton r7c6;
    private javax.swing.JButton r7c7;
    private javax.swing.JButton r7c8;
    private javax.swing.JButton r7c9;
    private javax.swing.JButton r8c1;
    private javax.swing.JButton r8c2;
    private javax.swing.JButton r8c3;
    private javax.swing.JButton r8c4;
    private javax.swing.JButton r8c5;
    private javax.swing.JButton r8c6;
    private javax.swing.JButton r8c7;
    private javax.swing.JButton r8c8;
    private javax.swing.JButton r8c9;
    private javax.swing.JButton r9c1;
    private javax.swing.JButton r9c2;
    private javax.swing.JButton r9c3;
    private javax.swing.JButton r9c4;
    private javax.swing.JButton r9c5;
    private javax.swing.JButton r9c6;
    private javax.swing.JButton r9c7;
    private javax.swing.JButton r9c8;
    private javax.swing.JButton r9c9;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton selectionbtn1;
    private javax.swing.JButton selectionbtn2;
    private javax.swing.JButton selectionbtn3;
    private javax.swing.JButton selectionbtn4;
    private javax.swing.JButton selectionbtn5;
    private javax.swing.JButton selectionbtn6;
    private javax.swing.JButton selectionbtn7;
    private javax.swing.JButton selectionbtn8;
    private javax.swing.JButton selectionbtn9;
    private javax.swing.JButton solutionbtn;
    private javax.swing.JButton undobtn;
    // End of variables declaration//GEN-END:variables
}
