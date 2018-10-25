/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import classes.Book;
import classes.Book_User;
import classes.Book_loan;
import classes.Users_class;
import classes.register_class;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abdul
 */
public class Librarian extends javax.swing.JFrame {

    private int row=-1,col=-1;
    String username="";
    private Users_class obj;
    private Book book_loan;
    /**
     * Creates new form Librarian
     */
    public Librarian() {
        initComponents();
    }
    public Librarian(Users_class a) {
       
        
        
        initComponents();
        obj=a;
       t_name.setText(a.Name);
        t_username.setText(a.username);
        t_email.setText(a.Email);
        t_pno.setText(a.PhoneNumber);
        //Books.get(0).getbook();
        initIssuebook();
        initBooksreq();
        initBooksret();
        initnewusers();
        
        
        this.setVisible(true);
    }
    public void initnewusers()
    {
        DefaultTableModel model = (DefaultTableModel) tl_newusers.getModel();
        model.setRowCount(0);
        
         ArrayList<register_class> newusers=obj.getnewusers();
         
        if(newusers!=null)
        {
            int rows=newusers.size();
         model.setRowCount(rows);
         model.setColumnCount(6);
         tl_books.setModel(model);
         ListIterator<register_class> iter=null;
         iter=newusers.listIterator();
          int i=0;
         while (iter.hasNext()) {
             register_class temp=iter.next();
             
             tl_books.setValueAt(Integer.toString(i+1),i,0);
             tl_books.setValueAt(temp.getusername(),i,1);
         tl_books.setValueAt(temp.getpass(),i,2);
         tl_books.setValueAt(temp.getname(),i,3);
         tl_books.setValueAt(temp.getemail(),i,4);
         tl_books.setValueAt(temp.getpno(),i,5);
         
         i++;
      }
        }
    }
    public void initIssuebook()
    {
        DefaultTableModel model = (DefaultTableModel) tl_books.getModel();
        model.setRowCount(0);
        DefaultComboBoxModel jcmodel = (DefaultComboBoxModel) jc_books.getModel();
            jcmodel.removeAllElements();
         ArrayList<Book_loan> Books=obj.getbooks();
        if(Books!=null)
        {
            int rows=Books.size();
         model.setRowCount(rows);
         model.setColumnCount(4);
         tl_books.setModel(model);
         ListIterator<Book_loan> iter=null;
         iter=Books.listIterator();
          int i=0;
         while (iter.hasNext()) {
             Book_loan temp=iter.next();
             String book=temp.getbook().getTitle()+" by "+temp.getbook().getAuthor()+" edition "+temp.getbook().getEdition();
             jcmodel.addElement(book);
             tl_books.setValueAt(Integer.toString(i+1),i,0);
             tl_books.setValueAt(book,i,1);
         tl_books.setValueAt(temp.getissue(),i,2);
         tl_books.setValueAt(temp.getret(),i,3);
         
         i++;
      }
        }
    }
    public void initBooksreq()
    {
        
        DefaultTableModel model = (DefaultTableModel) tl_reqbooks.getModel();
        model.setRowCount(0);
        
        ArrayList<Book_User> Booksreq=obj.lib.getreq();
        
        if(Booksreq!=null)
        {
         int rows=Booksreq.size();
         model.setRowCount(rows);
         model.setColumnCount(3);
         tl_reqbooks.setModel(model);
         ListIterator<Book_User> iter=null;
         iter=Booksreq.listIterator();
        
          int i=0;
         while (iter.hasNext()) {
             Book_User temp=iter.next();
         //    tl_reqbooks.add(Row);
             String book=temp.getBook().getTitle()+" by "+temp.getBook().getAuthor()+" edition "+temp.getBook().getEdition();
         tl_reqbooks.setValueAt(Integer.toString(i+1),i,0);
             tl_reqbooks.setValueAt(book,i,2);
         tl_reqbooks.setValueAt(temp.getUser().username,i,1);
         
         
         i++;
      }
        }
    }
    public void initBooksret()
    {
        DefaultTableModel model = (DefaultTableModel) tl_retbooks.getModel();
        model.setRowCount(0);
        ArrayList<Book_User> Booksret=obj.lib.getret();
        if(Booksret!=null)
        {
            int rows=Booksret.size();
         model.setRowCount(rows);
         model.setColumnCount(3);
         tl_retbooks.setModel(model);
         ListIterator<Book_User> iter=null;
         iter=Booksret.listIterator();
          int i=0;
         while (iter.hasNext()) {
             Book_User temp=iter.next();
             String book=temp.getBook().getTitle()+" by "+temp.getBook().getAuthor()+" edition "+temp.getBook().getEdition();
         tl_retbooks.setValueAt(Integer.toString(i+1),i,0);
             tl_retbooks.setValueAt(book,i,2);
         tl_retbooks.setValueAt(temp.getUser().username,i,1);
         
         
         i++;
      }
        }
    }
    void refresh()
    {
        initIssuebook();
        initBooksreq();
        initBooksret();
        initnewusers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kButton1 = new keeptoo.KButton();
        c_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        n_password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        nc_password = new javax.swing.JPasswordField();
        jDialog4 = new javax.swing.JDialog();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        kButton4 = new keeptoo.KButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDialog7 = new javax.swing.JDialog();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        kButton5 = new keeptoo.KButton();
        jLabel13 = new javax.swing.JLabel();
        jedit_username = new javax.swing.JTextField();
        jDialog8 = new javax.swing.JDialog();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel16 = new javax.swing.JLabel();
        et_email = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        et_name = new javax.swing.JTextField();
        et_pno = new javax.swing.JTextField();
        et_pass = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        kButton6 = new keeptoo.KButton();
        jDialog9 = new javax.swing.JDialog();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        kButton7 = new keeptoo.KButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jDialog10 = new javax.swing.JDialog();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        kButton8 = new keeptoo.KButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jDialog11 = new javax.swing.JDialog();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        kButton9 = new keeptoo.KButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jDialog12 = new javax.swing.JDialog();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        kButton10 = new keeptoo.KButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jDialog2 = new javax.swing.JDialog();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        kButton2 = new keeptoo.KButton();
        l_label123 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        l_book = new javax.swing.JTextField();
        jDialog13 = new javax.swing.JDialog();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jc_book = new javax.swing.JComboBox<>();
        kButton11 = new keeptoo.KButton();
        jDialog3 = new javax.swing.JDialog();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        book_return = new keeptoo.KButton();
        jLabel11 = new javax.swing.JLabel();
        jc_books = new javax.swing.JComboBox<>();
        jDialog5 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tl_books = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jDialog6 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tl_reqbooks = new javax.swing.JTable();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        req_acc = new javax.swing.JMenuItem();
        req_rej = new javax.swing.JMenuItem();
        jDialog14 = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tl_retbooks = new javax.swing.JTable();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        ret_acc = new javax.swing.JMenuItem();
        jDialog15 = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tl_newusers = new javax.swing.JTable();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        acc_new = new javax.swing.JMenuItem();
        rej_new = new javax.swing.JMenuItem();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        t_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t_pno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        jDialog1.setTitle("Password Change");
        jDialog1.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setText("Update Password");
        kButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton1.setkBorderRadius(40);
        kButton1.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        c_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        c_password.setOpaque(false);
        c_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_passwordActionPerformed(evt);
            }
        });
        kGradientPanel2.add(c_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Current Password");
        kGradientPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("New Password:");
        kGradientPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 30));

        n_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        n_password.setOpaque(false);
        n_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_passwordActionPerformed(evt);
            }
        });
        kGradientPanel2.add(n_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Confirm Password");
        kGradientPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, 30));

        nc_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        nc_password.setOpaque(false);
        nc_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nc_passwordActionPerformed(evt);
            }
        });
        kGradientPanel2.add(nc_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 30));

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        jDialog4.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel5.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel5.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton4.setText("Extend Duration");
        kButton4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton4.setkBorderRadius(40);
        kButton4.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton4.setOpaque(false);
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Select Book");
        kGradientPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 40));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setOpaque(false);
        kGradientPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog7.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel6.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel6.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel6.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton5.setText("Edit Info");
        kButton5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton5.setkBorderRadius(40);
        kButton5.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton5.setOpaque(false);
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });
        kGradientPanel6.add(kButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Select Student");
        kGradientPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jedit_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jedit_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jedit_username.setOpaque(false);
        jedit_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jedit_usernameActionPerformed(evt);
            }
        });
        kGradientPanel6.add(jedit_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 39));

        javax.swing.GroupLayout jDialog7Layout = new javax.swing.GroupLayout(jDialog7.getContentPane());
        jDialog7.getContentPane().setLayout(jDialog7Layout);
        jDialog7Layout.setHorizontalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog7Layout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog7Layout.setVerticalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog8.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel7.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel7.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Name");
        kGradientPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 70, 30));

        et_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        et_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        et_email.setOpaque(false);
        et_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_emailActionPerformed(evt);
            }
        });
        kGradientPanel7.add(et_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, 39));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Email");
        kGradientPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 70, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText("Phone No.");
        kGradientPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 70, 30));

        et_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        et_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        et_name.setOpaque(false);
        et_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_nameActionPerformed(evt);
            }
        });
        kGradientPanel7.add(et_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 210, 39));

        et_pno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        et_pno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        et_pno.setOpaque(false);
        et_pno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_pnoActionPerformed(evt);
            }
        });
        kGradientPanel7.add(et_pno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 210, 39));

        et_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        et_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        et_pass.setOpaque(false);
        et_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_passActionPerformed(evt);
            }
        });
        kGradientPanel7.add(et_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 210, 39));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Password");
        kGradientPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 70, 30));

        kButton6.setText("Update Info");
        kButton6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton6.setkBorderRadius(40);
        kButton6.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton6.setOpaque(false);
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });
        kGradientPanel7.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, -1));

        javax.swing.GroupLayout jDialog8Layout = new javax.swing.GroupLayout(jDialog8.getContentPane());
        jDialog8.getContentPane().setLayout(jDialog8Layout);
        jDialog8Layout.setHorizontalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        jDialog8Layout.setVerticalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );

        jDialog9.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel8.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel8.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton7.setText("Add Book");
        kButton7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton7.setkBorderRadius(40);
        kButton7.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton7.setOpaque(false);
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });
        kGradientPanel8.add(kButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Book Title");
        kGradientPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Book Author");
        kGradientPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Book Subject");
        kGradientPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, 30));

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(255, 255, 255));
        jTextField17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField17.setOpaque(false);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        kGradientPanel8.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 39));

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(255, 255, 255));
        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField18.setOpaque(false);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        kGradientPanel8.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, 39));

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(255, 255, 255));
        jTextField19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField19.setOpaque(false);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        kGradientPanel8.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 39));

        javax.swing.GroupLayout jDialog9Layout = new javax.swing.GroupLayout(jDialog9.getContentPane());
        jDialog9.getContentPane().setLayout(jDialog9Layout);
        jDialog9Layout.setHorizontalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog9Layout.createSequentialGroup()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog9Layout.setVerticalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog9Layout.createSequentialGroup()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDialog10.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel9.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel9.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton8.setText("Delete Book");
        kButton8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton8.setkBorderRadius(40);
        kButton8.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton8.setOpaque(false);
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Select Book");
        kGradientPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/Capture.PNG"))); // NOI18N
        jLabel24.setText("jLabel10");
        kGradientPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 50));

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(255, 255, 255));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField15.setOpaque(false);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 39));

        javax.swing.GroupLayout jDialog10Layout = new javax.swing.GroupLayout(jDialog10.getContentPane());
        jDialog10.getContentPane().setLayout(jDialog10Layout);
        jDialog10Layout.setHorizontalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog10Layout.createSequentialGroup()
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog10Layout.setVerticalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog11.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel10.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel10.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton9.setText("Edit Book");
        kButton9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton9.setkBorderRadius(40);
        kButton9.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton9.setOpaque(false);
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });
        kGradientPanel10.add(kButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Select Book");
        kGradientPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/Capture.PNG"))); // NOI18N
        jLabel26.setText("jLabel10");
        kGradientPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 50));

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(255, 255, 255));
        jTextField16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField16.setOpaque(false);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        kGradientPanel10.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 39));

        javax.swing.GroupLayout jDialog11Layout = new javax.swing.GroupLayout(jDialog11.getContentPane());
        jDialog11.getContentPane().setLayout(jDialog11Layout);
        jDialog11Layout.setHorizontalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog11Layout.createSequentialGroup()
                .addComponent(kGradientPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog11Layout.setVerticalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog12.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel11.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel11.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel11.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton10.setText("Update Book");
        kButton10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton10.setkBorderRadius(40);
        kButton10.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton10.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton10.setOpaque(false);
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });
        kGradientPanel11.add(kButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("Book Title");
        kGradientPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Book Author");
        kGradientPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Book Subject");
        kGradientPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, 30));

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(255, 255, 255));
        jTextField20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField20.setOpaque(false);
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        kGradientPanel11.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 39));

        jTextField21.setEditable(false);
        jTextField21.setBackground(new java.awt.Color(255, 255, 255));
        jTextField21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField21.setOpaque(false);
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        kGradientPanel11.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, 39));

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(255, 255, 255));
        jTextField22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField22.setOpaque(false);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        kGradientPanel11.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 39));

        javax.swing.GroupLayout jDialog12Layout = new javax.swing.GroupLayout(jDialog12.getContentPane());
        jDialog12.getContentPane().setLayout(jDialog12Layout);
        jDialog12Layout.setHorizontalGroup(
            jDialog12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog12Layout.createSequentialGroup()
                .addComponent(kGradientPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog12Layout.setVerticalGroup(
            jDialog12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog12Layout.createSequentialGroup()
                .addComponent(kGradientPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDialog2.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel3.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton2.setText("Add Book");
        kButton2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton2.setkBorderRadius(40);
        kButton2.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton2.setOpaque(false);
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        kGradientPanel3.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        l_label123.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        l_label123.setForeground(new java.awt.Color(204, 204, 204));
        l_label123.setText("Select Book");
        kGradientPanel3.add(l_label123, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/Capture.PNG"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 60));

        l_book.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        l_book.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        l_book.setOpaque(false);
        l_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_bookActionPerformed(evt);
            }
        });
        kGradientPanel3.add(l_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, 30));

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog13.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel12.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel12.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel12.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jc_book.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nothing Found" }));
        jc_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_bookActionPerformed(evt);
            }
        });
        kGradientPanel12.add(jc_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 170, 400, 30));

        kButton11.setText("Select book");
        kButton11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        kButton11.setkBorderRadius(40);
        kButton11.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton11.setOpaque(false);
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });
        kGradientPanel12.add(kButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        javax.swing.GroupLayout jDialog13Layout = new javax.swing.GroupLayout(jDialog13.getContentPane());
        jDialog13.getContentPane().setLayout(jDialog13Layout);
        jDialog13Layout.setHorizontalGroup(
            jDialog13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog13Layout.createSequentialGroup()
                .addComponent(kGradientPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog13Layout.setVerticalGroup(
            jDialog13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog3.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel4.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel4.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel4.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        book_return.setText("Return");
        book_return.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        book_return.setkBorderRadius(40);
        book_return.setkEndColor(new java.awt.Color(102, 102, 255));
        book_return.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        book_return.setOpaque(false);
        book_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_returnActionPerformed(evt);
            }
        });
        kGradientPanel4.add(book_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Select Book");
        kGradientPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 40));

        jc_books.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jc_books.setOpaque(false);
        kGradientPanel4.add(jc_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog5.setSize(new java.awt.Dimension(500, 500));

        tl_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tl_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tl_booksMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tl_books);

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jMenuItem11.setText("jMenuItem11");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem11);

        jMenuItem10.setText("jMenuItem10");
        jPopupMenu1.add(jMenuItem10);

        jDialog6.setSize(new java.awt.Dimension(500, 500));

        tl_reqbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tl_reqbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tl_reqbooksMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tl_reqbooks);

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
            .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        req_acc.setText("jMenuItem12");
        req_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                req_accActionPerformed(evt);
            }
        });
        jPopupMenu2.add(req_acc);

        req_rej.setText("jMenuItem13");
        req_rej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                req_rejActionPerformed(evt);
            }
        });
        jPopupMenu2.add(req_rej);

        jDialog14.setSize(new java.awt.Dimension(500, 500));

        tl_retbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tl_retbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tl_retbooksMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tl_retbooks);

        javax.swing.GroupLayout jDialog14Layout = new javax.swing.GroupLayout(jDialog14.getContentPane());
        jDialog14.getContentPane().setLayout(jDialog14Layout);
        jDialog14Layout.setHorizontalGroup(
            jDialog14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
        );
        jDialog14Layout.setVerticalGroup(
            jDialog14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog14Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 396, Short.MAX_VALUE))
        );

        ret_acc.setText("jMenuItem14");
        ret_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_accActionPerformed(evt);
            }
        });
        jPopupMenu3.add(ret_acc);

        tl_newusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tl_newusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tl_newusersMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tl_newusers);

        javax.swing.GroupLayout jDialog15Layout = new javax.swing.GroupLayout(jDialog15.getContentPane());
        jDialog15.getContentPane().setLayout(jDialog15Layout);
        jDialog15Layout.setHorizontalGroup(
            jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog15Layout.setVerticalGroup(
            jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        acc_new.setText("jMenuItem12");
        acc_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_newActionPerformed(evt);
            }
        });
        jPopupMenu4.add(acc_new);

        rej_new.setText("jMenuItem13");
        rej_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rej_newActionPerformed(evt);
            }
        });
        jPopupMenu4.add(rej_new);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/149071_3ObHrl.jpg"))); // NOI18N
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        t_name.setEditable(false);
        t_name.setBackground(new java.awt.Color(255, 255, 255));
        t_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        t_name.setOpaque(false);
        t_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nameActionPerformed(evt);
            }
        });
        kGradientPanel1.add(t_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 210, 39));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Name");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 70, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Email");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 70, 30));

        t_email.setEditable(false);
        t_email.setBackground(new java.awt.Color(255, 255, 255));
        t_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        t_email.setOpaque(false);
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        kGradientPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 210, 39));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Phone No.");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 70, 30));

        t_pno.setEditable(false);
        t_pno.setBackground(new java.awt.Color(255, 255, 255));
        t_pno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_pno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        t_pno.setOpaque(false);
        t_pno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_pnoActionPerformed(evt);
            }
        });
        kGradientPanel1.add(t_pno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 210, 39));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("UserName");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 70, 30));

        t_username.setEditable(false);
        t_username.setBackground(new java.awt.Color(255, 255, 255));
        t_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        t_username.setOpaque(false);
        t_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_usernameActionPerformed(evt);
            }
        });
        kGradientPanel1.add(t_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 210, 39));

        jMenu1.setText("File");

        jMenuItem1.setText("Issue New Book");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Issued Book");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setText("Check-out Book");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Check-in Book");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Add New Student");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem14.setText("Add New Book");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem15.setText("Delete Book");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("Extend Book Duration");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Return a Book");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Change Password");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem9.setText("Update Student");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem16.setText("Update Book");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jDialog2.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jDialog5.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        jDialog6.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jDialog15.setVisible(true);

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jDialog4.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        jDialog3.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        String search=jedit_username.getText();
        
        if(obj.SearchUser(search))
        {
            username=search;
            jDialog7.setVisible(false);
            jDialog8.setVisible(true);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "No user with such username");      }
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        char[] pass;
        pass = c_password.getPassword();
        String c_Pass=new String(pass);
        
        if(obj.validate(obj.username,c_Pass))
        {
            pass = n_password.getPassword();
         c_Pass=new String(pass);
         pass = nc_password.getPassword();
        String nc_Pass=new String(pass);
        if( c_Pass.equals(nc_Pass))
        {
            obj.setPassword(c_Pass);
            JOptionPane.showMessageDialog(null, "Password changed");
            jDialog1.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Passwords dont match");
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect Password!");
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void c_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_passwordActionPerformed

    private void n_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_passwordActionPerformed

    private void nc_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nc_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nc_passwordActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        jDialog8.show();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void jedit_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jedit_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jedit_usernameActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton8ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        // TODO add your handling code here:
        jDialog12.show();
    }//GEN-LAST:event_kButton9ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton10ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        jDialog9.show();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        jDialog10.show();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        jDialog11.show();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        String book=l_label123.getText();
        l_book.setText("");
        l_book.setEditable(true);
        if(book_loan!=null)
        {
            if(obj.searchreqbook(book_loan)==false)
            {
                obj.reqBook(book_loan);
                JOptionPane.showMessageDialog(null, "Added");
                jDialog2.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Book already requested");
                jDialog2.setVisible(false);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No book found");
        }
        refresh();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String search=l_book.getText();
        book_loan=obj.Search(search);
        if(book_loan!=null)
        {
            jDialog13.setVisible(true);
            DefaultComboBoxModel model = (DefaultComboBoxModel) jc_book.getModel();
            model.removeAllElements();
            model.addElement(book_loan.getTitle()+" by "+book_loan.getAuthor()+"edition "+book_loan.getEdition());

        }
        else
        {
            jDialog13.setVisible(true);
            DefaultComboBoxModel model = (DefaultComboBoxModel) jc_book.getModel();
            model.removeAllElements();
            model.addElement("Nothing Found");
            l_book.setEditable(true);
            kButton5.setText("Close");        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void l_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_bookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_bookActionPerformed

    private void jc_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_bookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_bookActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
        String book=jc_book.getSelectedItem().toString();
        if(book.equals("Nothing Found"))
        {

        }
        else
        {

            l_book.setText(book);

            l_book.setEditable(false);
        }
        jDialog13.setVisible(false);
    }//GEN-LAST:event_kButton11ActionPerformed

    private void book_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_returnActionPerformed
        // TODO add your handling code here:
        int book=jc_books.getSelectedIndex();

        if(obj.searchretbook(book)==false)
        {
            Book temp=obj.Books.get(book).getbook();
            obj.retBook(temp);
            JOptionPane.showMessageDialog(null, "Return Requested");
            jDialog3.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Already Return Requested");
        }
        refresh();
    }//GEN-LAST:event_book_returnActionPerformed

    private void tl_booksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tl_booksMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tl_booksMouseReleased

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void tl_reqbooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tl_reqbooksMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger())
        {
            jPopupMenu2.show(tl_reqbooks, evt.getX(), evt.getY());
            row = tl_reqbooks.rowAtPoint(evt.getPoint());
            col = tl_reqbooks.columnAtPoint(evt.getPoint());
            req_acc.setText("Accept");
            req_rej.setText("Reject");

        }
    }//GEN-LAST:event_tl_reqbooksMouseReleased

    private void req_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_accActionPerformed
        // TODO add your handling code here:
        Book_User a=obj.lib.getfromreq(row);
        if(a.getBook().isStatus()==1)
        {    
            obj.check_out(a);
            JOptionPane.showMessageDialog(null, "Book Issued");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Book already Issued to someone Please wait till return");
        }
        refresh();
       
    }//GEN-LAST:event_req_accActionPerformed

    private void req_rejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_rejActionPerformed
        // TODO add your handling code here:
        obj.lib.removefromreq(row);
        JOptionPane.showMessageDialog(null, "Removed");
        refresh();
    }//GEN-LAST:event_req_rejActionPerformed

    private void tl_retbooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tl_retbooksMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger())
        {
            jPopupMenu3.show(tl_retbooks, evt.getX(), evt.getY());
            row = tl_retbooks.rowAtPoint(evt.getPoint());
            col = tl_retbooks.columnAtPoint(evt.getPoint());
            ret_acc.setText("Accept");

        }
    }//GEN-LAST:event_tl_retbooksMouseReleased

    private void ret_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_accActionPerformed
        // TODO add your handling code here:
        Book_User a=obj.lib.getfromret(row);
        
        obj.check_in(a);
        JOptionPane.showMessageDialog(null, "Book Added to inventory");
        refresh();

    }//GEN-LAST:event_ret_accActionPerformed

    private void t_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nameActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void t_pnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_pnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_pnoActionPerformed

    private void t_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_usernameActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        jDialog14.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void et_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_emailActionPerformed

    private void et_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_nameActionPerformed

    private void et_pnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_pnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_pnoActionPerformed

    private void et_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_passActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        String name=et_name.getText();
        String email=et_email.getText();
        String pno=et_pno.getText();
        String pass=et_pass.getText();
        if(name.isEmpty() || email.isEmpty() || pno.isEmpty() || pass.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "All feilds are required");
        }
        else
        {
            obj.Updateuser(username, name, email, pno, pass);
             JOptionPane.showMessageDialog(null, "Updated");
              jDialog8.setVisible(false);
        }

    }//GEN-LAST:event_kButton6ActionPerformed

    private void tl_newusersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tl_newusersMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger())
        {
            jPopupMenu4.show(tl_newusers, evt.getX(), evt.getY());
            row = tl_newusers.rowAtPoint(evt.getPoint());
            col = tl_newusers.columnAtPoint(evt.getPoint());
            acc_new.setText("Add");
            rej_new.setText("Delete");

        }
    }//GEN-LAST:event_tl_newusersMouseReleased

    private void acc_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_newActionPerformed
        // TODO add your handling code here:
        obj.adduser(row);
        JOptionPane.showMessageDialog(null, "User added");
        jDialog15.setVisible(false);

    }//GEN-LAST:event_acc_newActionPerformed

    private void rej_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rej_newActionPerformed
        // TODO add your handling code here:
        obj.removenwuser(row);
        JOptionPane.showMessageDialog(null, "User removed");
        jDialog15.setVisible(false);
    }//GEN-LAST:event_rej_newActionPerformed

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
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Librarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acc_new;
    private keeptoo.KButton book_return;
    private javax.swing.JPasswordField c_password;
    private javax.swing.JTextField et_email;
    private javax.swing.JTextField et_name;
    private javax.swing.JTextField et_pass;
    private javax.swing.JTextField et_pno;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog10;
    private javax.swing.JDialog jDialog11;
    private javax.swing.JDialog jDialog12;
    private javax.swing.JDialog jDialog13;
    private javax.swing.JDialog jDialog14;
    private javax.swing.JDialog jDialog15;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JDialog jDialog8;
    private javax.swing.JDialog jDialog9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JComboBox<String> jc_book;
    private javax.swing.JComboBox<String> jc_books;
    private javax.swing.JTextField jedit_username;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JTextField l_book;
    private javax.swing.JLabel l_label123;
    private javax.swing.JPasswordField n_password;
    private javax.swing.JPasswordField nc_password;
    private javax.swing.JMenuItem rej_new;
    private javax.swing.JMenuItem req_acc;
    private javax.swing.JMenuItem req_rej;
    private javax.swing.JMenuItem ret_acc;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_name;
    private javax.swing.JTextField t_pno;
    private javax.swing.JTextField t_username;
    private javax.swing.JTable tl_books;
    private javax.swing.JTable tl_newusers;
    private javax.swing.JTable tl_reqbooks;
    private javax.swing.JTable tl_retbooks;
    // End of variables declaration//GEN-END:variables
}
