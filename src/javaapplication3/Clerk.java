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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abdul
 */
public class Clerk extends javax.swing.JFrame {

    /**
     * Creates new form Clerk
     */
    private int row=-1,col=-1;
    private Users_class obj;
    private Book book_loan;
    private ArrayList<Book> book_loans;
    private String username="";
    public Clerk() {
        initComponents();
        
    }
    public Clerk(Users_class a) {
       
        
        this.addWindowListener(new WindowAdapter() {
  @Override
  public void windowClosing(WindowEvent we) {
      Users_class.lib.logout(obj.username);
      System.exit(0);
  }
});
        initComponents();
        obj=a;
       t_name.setText(a.Name);
        t_username.setText(a.username);
        t_email.setText(a.Email);
        t_pno.setText(a.PhoneNumber);
        t_fine.setText(Integer.toString(a.computefine()));
        //Books.get(0).getbook();
        initIssuebook();
        initBooksreq();
        initBooksret();
        initnewusers();
        
        
        
        this.setVisible(true);
    }
    public void initIssuebook()
    {
        DefaultTableModel model = (DefaultTableModel) tl_books.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        
        DefaultComboBoxModel jcmodel = (DefaultComboBoxModel) jc_books.getModel();
            jcmodel.removeAllElements();
         ArrayList<Book_loan> Books=obj.getbooks();
        if(Books!=null)
        {
            int rows=Books.size();
         model.setRowCount(rows);
         model.addColumn("Sr No.");
         model.addColumn("Book");
         model.addColumn("Issue Data");
         model.addColumn("Expiry Date");
         model.addColumn("Fine");
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
         tl_books.setValueAt(temp.myfine(),i,4);
         i++;
      }
        }
    }
     public void initnewusers()
    {
        DefaultTableModel model = (DefaultTableModel) tl_newusers.getModel();
       model.setRowCount(0);
        model.setColumnCount(0);
        
        
         ArrayList<register_class> newusers=obj.getnewusers();
         
        if(newusers!=null)
        {
            int rows=newusers.size();
         model.setRowCount(rows);
         model.addColumn("Sr No.");
         model.addColumn("User Name");
         model.addColumn("Password");
         model.addColumn("Name");
         model.addColumn("Email");
         model.addColumn("Phone No.");
         tl_newusers.setModel(model);
         ListIterator<register_class> iter=null;
         iter=newusers.listIterator();
          int i=0;
         while (iter.hasNext()) {
             register_class temp=iter.next();
             
             tl_newusers.setValueAt(Integer.toString(i+1),i,0);
             tl_newusers.setValueAt(temp.getusername(),i,1);
         tl_newusers.setValueAt(temp.getpass(),i,2);
         tl_newusers.setValueAt(temp.getname(),i,3);
         tl_newusers.setValueAt(temp.getemail(),i,4);
         tl_newusers.setValueAt(temp.getpno(),i,5);
         
         i++;
      }
        }
    }
    public void initBooksreq()
    {
        
        DefaultTableModel model = (DefaultTableModel) tl_reqbooks.getModel();
       model.setRowCount(0);
        model.setColumnCount(0);
        
        
        ArrayList<Book_User> Booksreq=obj.lib.getreq();
        
        if(Booksreq!=null)
        {
         int rows=Booksreq.size();
         model.setRowCount(rows);
          model.addColumn("Sr No.");
         model.addColumn("User Name");
         model.addColumn("Book");
         
         
         
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
        model.setColumnCount(0);
        
        ArrayList<Book_User> Booksret=obj.lib.getret();
        if(Booksret!=null)
        {
            int rows=Booksret.size();
         model.setRowCount(rows);
          model.addColumn("Sr No.");
         model.addColumn("User Name");
         model.addColumn("Book");
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
        try {
            Users_class.lib.init();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        initBooksreq();
        initBooksret();
        initIssuebook();
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
        jDialog2 = new javax.swing.JDialog();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        kButton2 = new keeptoo.KButton();
        l_label123 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        l_book = new javax.swing.JTextField();
        jDialog4 = new javax.swing.JDialog();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        kButton4 = new keeptoo.KButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tl_retbooks = new javax.swing.JTable();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        ret_acc = new javax.swing.JMenuItem();
        jDialog10 = new javax.swing.JDialog();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jc_book = new javax.swing.JComboBox<>();
        kButton7 = new keeptoo.KButton();
        jDialog3 = new javax.swing.JDialog();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        book_return = new keeptoo.KButton();
        jLabel11 = new javax.swing.JLabel();
        jc_books = new javax.swing.JComboBox<>();
        jDialog11 = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tl_newusers = new javax.swing.JTable();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        acc_new = new javax.swing.JMenuItem();
        rej_new = new javax.swing.JMenuItem();
        jDialog18 = new javax.swing.JDialog();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        kButton8 = new keeptoo.KButton();
        jLabel14 = new javax.swing.JLabel();
        jdel_username = new javax.swing.JTextField();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        j_return = new javax.swing.JMenuItem();
        j_extend = new javax.swing.JMenuItem();
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
        jLabel9 = new javax.swing.JLabel();
        t_fine = new javax.swing.JTextField();
        kButton3 = new keeptoo.KButton();
        change_password1 = new keeptoo.KButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

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
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
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
            .addGap(0, 849, Short.MAX_VALUE)
            .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
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
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog7Layout.setVerticalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jDialog9Layout = new javax.swing.GroupLayout(jDialog9.getContentPane());
        jDialog9.getContentPane().setLayout(jDialog9Layout);
        jDialog9Layout.setHorizontalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        jDialog9Layout.setVerticalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        ret_acc.setText("jMenuItem14");
        ret_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_accActionPerformed(evt);
            }
        });
        jPopupMenu3.add(ret_acc);

        jDialog10.setSize(new java.awt.Dimension(500, 500));

        kGradientPanel8.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel8.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jc_book.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nothing Found" }));
        jc_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_bookActionPerformed(evt);
            }
        });
        kGradientPanel8.add(jc_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 170, 400, 30));

        kButton7.setText("Select book");
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
        kGradientPanel8.add(kButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        javax.swing.GroupLayout jDialog10Layout = new javax.swing.GroupLayout(jDialog10.getContentPane());
        jDialog10.getContentPane().setLayout(jDialog10Layout);
        jDialog10Layout.setHorizontalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog10Layout.setVerticalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        jDialog11.setSize(new java.awt.Dimension(1000, 1000));

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

        javax.swing.GroupLayout jDialog11Layout = new javax.swing.GroupLayout(jDialog11.getContentPane());
        jDialog11.getContentPane().setLayout(jDialog11Layout);
        jDialog11Layout.setHorizontalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
            .addGroup(jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
        );
        jDialog11Layout.setVerticalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        acc_new.setText("jMenuItem12");
        acc_new.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
                acc_newMenuKeyReleased(evt);
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
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

        jDialog18.setSize(new java.awt.Dimension(1000, 1000));

        kGradientPanel9.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kGradientPanel9.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton8.setText("Delete User");
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

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Select Student");
        kGradientPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jdel_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jdel_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jdel_username.setOpaque(false);
        jdel_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdel_usernameActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jdel_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 39));

        javax.swing.GroupLayout jDialog18Layout = new javax.swing.GroupLayout(jDialog18.getContentPane());
        jDialog18.getContentPane().setLayout(jDialog18Layout);
        jDialog18Layout.setHorizontalGroup(
            jDialog18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jDialog18Layout.setVerticalGroup(
            jDialog18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );

        j_return.setText("jMenuItem13");
        j_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_returnActionPerformed(evt);
            }
        });
        jPopupMenu5.add(j_return);

        j_extend.setText("jMenuItem14");
        jPopupMenu5.add(j_extend);

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Fine");
        kGradientPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, 80));

        t_fine.setEditable(false);
        t_fine.setBackground(new java.awt.Color(255, 255, 255));
        t_fine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_fine.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        t_fine.setOpaque(false);
        t_fine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_fineActionPerformed(evt);
            }
        });
        kGradientPanel1.add(t_fine, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 210, 39));

        kButton3.setText("Logout");
        kButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        change_password1.setText("See Details");
        change_password1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        change_password1.setkBorderRadius(40);
        change_password1.setkEndColor(new java.awt.Color(102, 102, 255));
        change_password1.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        change_password1.setOpaque(false);
        change_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_password1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(change_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 270, 50));

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

        jMenuItem12.setText("Delete User");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

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

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        refresh();
        if(obj.computefine()>500)
        {
            JOptionPane.showMessageDialog(null, "Can not issue new book First clear your fine");
        }
        else
        jDialog2.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        refresh();
        jDialog5.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jDialog4.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        refresh();
        jDialog3.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        refresh();
        jDialog1.setVisible(true);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

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

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        refresh();
        jDialog6.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void tl_booksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tl_booksMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger())
        {
            
            jPopupMenu5.show(tl_books, evt.getX(), evt.getY());
             row = tl_books.rowAtPoint(evt.getPoint());
             col = tl_books.columnAtPoint(evt.getPoint());
            String a=tl_books.getValueAt(row, 4).toString();
            int aa=Integer.parseInt(a);
            if(aa==0)
            {
                j_return.setText("Return Book");
                j_extend.setText("Extend Date");
            }
            else
            {
                j_return.setText("Return Book And Pay fine");
                j_extend.setText("Extend Date");
            }
        
        }
        
    }//GEN-LAST:event_tl_booksMouseReleased

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jDialog11.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
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
        
    }//GEN-LAST:event_kButton5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        jDialog7.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jedit_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jedit_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jedit_usernameActionPerformed

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

    private void req_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_accActionPerformed
        // TODO add your handling code here:
        
        Book_User a=obj.lib.getfromreq(row);
        if(a.getBook().isStatus()!=-1)
        {    
            obj.check_out(a);
            JOptionPane.showMessageDialog(null, "Book Issued");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Book has no copies left Please wait till return");
        }
        
        refresh();
    }//GEN-LAST:event_req_accActionPerformed

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

    private void req_rejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_rejActionPerformed
        // TODO add your handling code here:
        obj.lib.removefromreq(row);
        JOptionPane.showMessageDialog(null, "Removed");
       refresh();
    }//GEN-LAST:event_req_rejActionPerformed

    private void ret_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_accActionPerformed
        // TODO add your handling code here:
        Book_User a=obj.lib.getfromret(row);
        obj.check_in(a);
         JOptionPane.showMessageDialog(null, "Book Added to inventory");
         refresh();
        
    }//GEN-LAST:event_ret_accActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        refresh();
        jDialog9.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        String book=l_label123.getText();
        l_book.setText("");
        l_book.setEditable(true);
        if(book_loan!=null)
        {
            if(obj.searchreqbook(book_loan)==false && obj.searchbook(book_loan)==false)
            {
                if(obj.Books.size()>=5 || obj.computefine()>500)
                {
                    if(obj.Books.size()>=5)
                    {
                        JOptionPane.showMessageDialog(null, "Maximum Number of books reached");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Can issue first pay fine");
                    }
                
                    
                }
                else if(obj.checkissue(obj.username, book_loan.getId()))
                {
                            JOptionPane.showMessageDialog(null, "Can issue system does not allow same book issued again on same day");
                }
                else
                {
                    obj.reqBook(book_loan);
                     JOptionPane.showMessageDialog(null, "Added");
                    jDialog2.setVisible(false);
                }
            }
            else
            {
                if(obj.searchbook(book_loan))
                {
                    JOptionPane.showMessageDialog(null, "You already have a copy of this book. System does not allow two copies");
                }
                else
                {
                JOptionPane.showMessageDialog(null, "Book already requested");
                }
                jDialog2.setVisible(false);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No book found");
        }
        refresh();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void l_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_bookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_bookActionPerformed

    private void jc_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_bookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_bookActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        String book=jc_book.getSelectedItem().toString();
        int index=jc_book.getSelectedIndex();
        if(book_loans.isEmpty()==false)
        book_loan=book_loans.get(index);
        if(book.equals("Nothing Found"))
        {

        }
        else
        {

            l_book.setText(book);

            l_book.setEditable(false);
        }
        jDialog10.setVisible(false);

    }//GEN-LAST:event_kButton7ActionPerformed

    private void book_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_returnActionPerformed
        // TODO add your handling code here:
        int book=jc_books.getSelectedIndex();
        String a=tl_books.getValueAt(book, 4).toString();
        int aa=Integer.parseInt(a);
        if(obj.searchretbook(book)==false)
        {
            Book temp=obj.Books.get(book).getbook();
            obj.retBook(temp);
            if(aa==0)
        JOptionPane.showMessageDialog(null, "Return Requested");
         else
              JOptionPane.showMessageDialog(null, "Fine paid and Return Requested");
            jDialog3.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Already Return Requested");
        }
        refresh();
    }//GEN-LAST:event_book_returnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String search=l_book.getText();
         book_loans=obj.Search(search);
        if(book_loans.isEmpty()==false)
        {
            jDialog10.setVisible(true);
            DefaultComboBoxModel model = (DefaultComboBoxModel) jc_book.getModel();
            model.removeAllElements();
            ListIterator<Book> it=null;
            it=book_loans.listIterator();
            while(it.hasNext())
            {
                Book temp=it.next();
                model.addElement(temp.getTitle()+" by "+temp.getAuthor()+"edition "+temp.getEdition());
                
            }

        }
        else
        {
            jDialog10.setVisible(true);
            DefaultComboBoxModel model = (DefaultComboBoxModel) jc_book.getModel();
            model.removeAllElements();
            model.addElement("Nothing Found");
            l_book.setEditable(true);
            kButton7.setText("Close");        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        jDialog11.setVisible(false);
        refresh();
        
    }//GEN-LAST:event_acc_newActionPerformed

    private void rej_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rej_newActionPerformed
        // TODO add your handling code here:
        obj.removenwuser(row);
        JOptionPane.showMessageDialog(null, "User removed");
        jDialog11.setVisible(false);
        refresh();
    }//GEN-LAST:event_rej_newActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
         String search=jdel_username.getText();
        
        if(obj.SearchUser(search))
        {
            
            obj.deluser(username);
            JOptionPane.showMessageDialog(null, "User deleted"); 
            jDialog18.setVisible(false);
            

        }
        else
        {
            JOptionPane.showMessageDialog(null, "No user with such username");      }
        
    }//GEN-LAST:event_kButton8ActionPerformed

    private void jdel_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdel_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdel_usernameActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        jDialog18.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void j_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_returnActionPerformed
        // TODO add your handling code here:
        String a=tl_books.getValueAt(row, 4).toString();
        int aa=Integer.parseInt(a);
        if(obj.searchretbook(row)==false)
        {
        Book temp=obj.Books.get(row).getbook();
         obj.retBook(temp);
         if(aa==0)
        JOptionPane.showMessageDialog(null, "Return Requested");
         else
              JOptionPane.showMessageDialog(null, "Fine paid and Return Requested");
        jDialog3.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Already Return Requested"); 
        }
        refresh();
    }//GEN-LAST:event_j_returnActionPerformed

    private void t_fineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_fineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_fineActionPerformed

    private void acc_newMenuKeyReleased(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_acc_newMenuKeyReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_acc_newMenuKeyReleased

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
         obj.lib.logout(obj.username);
        signin a=new signin();
        this.setVisible(false);
    }//GEN-LAST:event_kButton3ActionPerformed

    private void change_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_password1ActionPerformed
        // TODO add your handling code here:
        jDialog5.setVisible(true);
    }//GEN-LAST:event_change_password1ActionPerformed

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
            java.util.logging.Logger.getLogger(Clerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clerk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acc_new;
    private keeptoo.KButton book_return;
    private javax.swing.JPasswordField c_password;
    private keeptoo.KButton change_password1;
    private javax.swing.JTextField et_email;
    private javax.swing.JTextField et_name;
    private javax.swing.JTextField et_pass;
    private javax.swing.JTextField et_pno;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog10;
    private javax.swing.JDialog jDialog11;
    private javax.swing.JDialog jDialog18;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
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
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuItem j_extend;
    private javax.swing.JMenuItem j_return;
    private javax.swing.JComboBox<String> jc_book;
    private javax.swing.JComboBox<String> jc_books;
    private javax.swing.JTextField jdel_username;
    private javax.swing.JTextField jedit_username;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KGradientPanel kGradientPanel1;
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
    private javax.swing.JTextField t_fine;
    private javax.swing.JTextField t_name;
    private javax.swing.JTextField t_pno;
    private javax.swing.JTextField t_username;
    private javax.swing.JTable tl_books;
    private javax.swing.JTable tl_newusers;
    private javax.swing.JTable tl_reqbooks;
    private javax.swing.JTable tl_retbooks;
    // End of variables declaration//GEN-END:variables
}
