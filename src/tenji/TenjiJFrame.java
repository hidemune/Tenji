/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenji;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author HDM
 */
public class TenjiJFrame extends javax.swing.JFrame {
public static int bit = 0;
public static int bitR = 0;

/*
//外付けテンキーNG
private char cKey1 = '7';
private char cKey2 = '4';
private char cKey3 = '1';
private char cKey4 = '8';
private char cKey5 = '5';
private char cKey6 = '2';
*/

/*
//HHKB Lite2 NG
private char cKey1 = 't';
private char cKey2 = 'g';
private char cKey3 = 'b';
private char cKey4 = 'i';
private char cKey5 = 'j';
private char cKey6 = 'n';
*/

/*
//HHKB Lite2 
private char cKey1 = 'q';
private char cKey2 = 'a';
private char cKey3 = 'z';
private char cKey4 = '[';
private char cKey5 = ':';
private char cKey6 = '/';
*/

/*
//これが正攻法らしい
//確かにちゃんと動く
//HHKB Lite2 
private char cKey1 = 's';
private char cKey2 = 'd';
private char cKey3 = 'f';
private char cKey4 = 'l';
private char cKey5 = 'k';
private char cKey6 = 'j';

private char cKeyBS = 'a';
private char cKeyYomi = ';';
*/

//使い辛いので右手だけで入力するよう変更。
//３点ずつ入力していくものとする。
private char cKey1 = 'l';
private char cKey2 = 'k';
private char cKey3 = 'j';
private char cKey4 = '.';
private char cKey5 = ',';
private char cKey6 = 'm';

private char cKeyBS = 'h';
private char cKeyYomi = KeyEvent.VK_ESCAPE;

    private void TenjiListClear() {
        tableKey.setValueAt(" " + cKey1 + " ", 0, 0);
        tableKey.setValueAt(" " + cKey2 + " ", 1, 0);
        tableKey.setValueAt(" " + cKey3 + " ", 2, 0);
        tableKey.setValueAt(" " + cKey4 + " ", 0, 1);
        tableKey.setValueAt(" " + cKey5 + " ", 1, 1);
        tableKey.setValueAt(" " + cKey6 + " ", 2, 1);
    }
    /**
     * Creates new form TenjiJFrame
     */
    public TenjiJFrame() {
        initComponents();
        TenjiListClear();
        enableInputMethods(false);      //IME止める
        //使用方法
        StringBuilder sb = new StringBuilder();
        sb.append("点字入力画面です。");
        sb.append("１段目は、人差し指を右手ホームポジションのジェイに置いて入力します。");
        sb.append("２段目は、人差し指を右手ホームポジションの右下のエムに置いて入力します。");
        
        sb.append("１文字確定はスペースキー、1文字削除するにはジェイの左隣のエイチを押します。");
        sb.append("エスケープを押すと、全文を読み上げます。");
        
        writeFile(sb.toString(), "UTF-8", textOutFile.getText());
        
    }

    public static void writeFile(String str, String enc, String filename) {
        if (str.equals("")) {
            return;
        }
        
        //CSVの書き込み
        try {
            File csv = new File(filename); // CSVデータファイル
            //古いファイルのバックアップ
            if (csv.exists()) {
    //            File fileB = new File(csv.getAbsolutePath() + "~");
    //            if (fileB.exists()) {
    //                fileB.delete();
    //            }
    //            csv.renameTo(fileB);
                //削除
                csv.delete();
            }
            // 常に新規作成
            PrintWriter bw;
            bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csv),enc)));

            //データ部
            bw.println(str);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableKey = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textHonbun = new javax.swing.JTextArea();
        textInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textOutFile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("点字入力");
        setFocusable(false);

        tableKey.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {" Q", " ["},
                {" A", " :"},
                {" Z", " /"}
            },
            new String [] {
                "1段目", "2段目"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKey.setEnabled(false);
        tableKey.setFocusable(false);
        jScrollPane1.setViewportView(tableKey);

        textHonbun.setEditable(false);
        textHonbun.setColumns(20);
        textHonbun.setLineWrap(true);
        textHonbun.setRows(5);
        jScrollPane2.setViewportView(textHonbun);

        textInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textInputKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textInputKeyReleased(evt);
            }
        });

        jLabel1.setText("スペースで１文字確定。同時押し不要。");

        textOutFile.setText("./openjtalk_infile.txt");
        textOutFile.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textOutFile, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 91, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textOutFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textInputKeyPressed
        char c = evt.getKeyChar();
        if (c == cKey1) {
            bit = bit | 1;
            tableKey.setValueAt("<" + c + ">", 0, 0);
        }
        if (c == cKey2) {
            bit = bit | 2;
            tableKey.setValueAt("<" + c + ">", 1, 0);
        }
        if (c == cKey3) {
            bit = bit | 4;
            tableKey.setValueAt("<" + c + ">", 2, 0);
        }
        if (c == cKey4) {
            bit = bit | 8;
            tableKey.setValueAt("<" + c + ">", 0, 1);
        }
        if (c == cKey5) {
            bit = bit | 16;
            tableKey.setValueAt("<" + c + ">", 1, 1);
        }
        if (c == cKey6) {
            bit = bit | 32;
            tableKey.setValueAt("<" + c + ">", 2, 1);
        }
        
        textInput.setText("" + bit);
    }//GEN-LAST:event_textInputKeyPressed

    private void textInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textInputKeyReleased
        
        char c = evt.getKeyChar();
        if (c == '\n') {
            //確定
            //String moji = getMoji(bit);
            textHonbun.setText(textHonbun.getText() + "\n");
            bit = 0;
            bitR = 0;
            TenjiListClear();
        }
        
        if (c == ' ') {
            //確定
            String moji = getMoji(bit);
            textHonbun.setText(textHonbun.getText() + moji);
            bit = 0;
            bitR = 0;
            TenjiListClear();
        }
        
        if (c == cKeyBS) {
            //1文字削除
            //String moji = getMoji(bit);
            String str = textHonbun.getText();
            textHonbun.setText(str.substring(0, str.length() - 1));
            bit = 0;
            bitR = 0;
            TenjiListClear();
        }
        if (c == cKeyYomi) {
            //全文読み上げ
            //String moji = getMoji(bit);
            String yomi = textHonbun.getText();
            writeFile(yomi, "UTF-8", textOutFile.getText());
            bit = 0;
            bitR = 0;
            TenjiListClear();
        }
    }//GEN-LAST:event_textInputKeyReleased
    
    private String getMoji(int bit) {
        String ret = "";
        //return "" + bit;
        
        switch (bit) {
            case 1:
                ret = "あ";
                break;
            case 3:
                ret = "い";
                break;
            case 9:
                ret = "う";
                break;
            case 11:
                ret = "え";
                break;
            case 10:
                ret = "お";
                break;
            case 33:
                ret = "か";
                break;
            case 35:
                ret = "き";
                break;
            case 41:
                ret = "く";
                break;
            case 43:
                ret = "け";
                break;
            case 42:
                ret = "こ";
                break;
            case 49:
                ret = "さ";
                break;
            case 51:
                ret = "し";
                break;
            case 57:
                ret = "す";
                break;
            case 59:
                ret = "せ";
                break;
            case 58:
                ret = "そ";
                break;
            case 21:
                ret = "た";
                break;
            case 23:
                ret = "ち";
                break;
            case 29:
                ret = "つ";
                break;
            case 31:
                ret = "て";
                break;
            case 30:
                ret = "と";
                break;
            case 5:
                ret = "な";
                break;
            case 7:
                ret = "に";
                break;
            case 13:
                ret = "ぬ";
                break;
            case 15:
                ret = "ね";
                break;
            case 14:
                ret = "の";
                break;
            case 37:
                ret = "は";
                break;
            case 39:
                ret = "ひ";
                break;
            case 45:
                ret = "ふ";
                break;
            case 47:
                ret = "へ";
                break;
            case 46:
                ret = "ほ";
                break;
            case 53:
                ret = "ま";
                break;
            case 55:
                ret = "み";
                break;
            case 61:
                ret = "む";
                break;
            case 63:
                ret = "め";
                break;
            case 62:
                ret = "も";
                break;
            case 12:
                ret = "や";
                break;
            case 44:
                ret = "ゆ";
                break;
            case 28:
                ret = "よ";
                break;
            case 17:
                ret = "ら";
                break;
            case 19:
                ret = "り";
                break;
            case 25:
                ret = "る";
                break;
            case 27:
                ret = "れ";
                break;
            case 26:
                ret = "ろ";
                break;
            case 4:
                ret = "わ";
                break;
            case 20:
                ret = "を";
                break;
            case 52:
                ret = "ん";
                break;
            case 18:
                ret = "ー";
                break;
            case 2:
                ret = "っ";
                break;
        }
        
        String yomi = ret;
        if (yomi.equals("ー")) {
            yomi = "長音記号";
        }
        if (yomi.equals("っ")) {
            yomi = "小さいつ";
        }
        writeFile(yomi, "UTF-8", textOutFile.getText());
        return ret;
    }
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
            java.util.logging.Logger.getLogger(TenjiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenjiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenjiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenjiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenjiJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableKey;
    private javax.swing.JTextArea textHonbun;
    private javax.swing.JTextField textInput;
    private javax.swing.JTextField textOutFile;
    // End of variables declaration//GEN-END:variables
}
