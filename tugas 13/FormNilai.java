package tugas13;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import tugas13.Mhs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author MSI GF63
 */
public class FormNilai extends javax.swing.JFrame {
DefaultTableModel tabel1;
Connection con;

public FormNilai() {
    initComponents();

    // koneksi database
    con = new DBConnection().getConnection();

    // inisialisasi tabel
    tabel1 = new DefaultTableModel();
    jTable1.setModel(tabel1);

    tabel1.addColumn("No");
    tabel1.addColumn("Nim");
    tabel1.addColumn("Nama");
    tabel1.addColumn("Nilai Uts");
    tabel1.addColumn("Nilai Uas");
    tabel1.addColumn("Nilai Tugas");
    tabel1.addColumn("Nilai Akhir");
    tabel1.addColumn("Nilai Huruf");
    tabel1.addColumn("Predikat");

    setResizable(false);

    try {
        tampilkanDiTabel();
    } catch (Exception e) {
        e.printStackTrace();
    }

    // disable field hasil
    nUTS.setEditable(true);
    nUAS.setEditable(true);
    nTugas.setEditable(true);
    nUTS1.setEditable(true);
    nTugas1.setEditable(true);
    nUAS1.setEditable(true);

    // disable tombol awal
    simpan.setEnabled(true);
    update.setEnabled(true);
    hapus.setEnabled(true);
    proses.setEnabled(true);
}

public void kosongkanTextField(){
    nim.setText("");
    nama.setText("");
    nUTS.setText("");
    nUAS.setText("");
    nTugas.setText("");

    nUTS.setText("");
    nUAS.setText("");
    nTugas.setText("");
    nUTS1.setText("");
    nTugas1.setText("");
    nUAS1.setText("");
}

public void prosesHitungNilai(){
    try{
        if (nUTS.getText().isEmpty() || 
            nUAS.getText().isEmpty() || 
            nTugas.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Input nilai harus diisi!");
            return;
        }

        double ts = Double.parseDouble(nUTS.getText());
        double as = Double.parseDouble(nUAS.getText());
        double tgs = Double.parseDouble(nTugas.getText());

        Mhs m = new Mhs(nim.getText(), nama.getText(), ts, as, tgs);

        nUTS1.setText(String.valueOf(m.uts()));
        nUAS1.setText(String.valueOf(m.uas()));
        nTugas1.setText(String.valueOf(m.tugas()));

        double na = m.nilaiAkhir();
        jTextField11.setText(String.valueOf(na)); // Nilai Akhir
        jTextField10.setText(m.getNilHuruf(na));  // Huruf
        jTextField9.setText(m.getPredikat(m.getNilHuruf(na))); // Predikat

    } catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
    }
}

public ArrayList<Object[]> getMhsList() throws SQLException {
    ArrayList<Object[]> list = new ArrayList<>();

    String query = "SELECT * FROM mhs";

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
        Object[] row = {
            rs.getString("nim"),
            rs.getString("nama"),
            rs.getDouble("nilai_uts"),
            rs.getDouble("nilai_uas"),
            rs.getDouble("nilai_tugas"),
            rs.getDouble("nilai_akhir"),
            rs.getString("nilai_huruf"),
            rs.getString("predikat")
        };

        list.add(row);
    }

    return list;
}

public void tampilkanDiTabel() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    ArrayList<Object[]> list = getMhsList();

    for (int i = 0; i < list.size(); i++) {
        Object[] data = list.get(i);

        model.addRow(new Object[]{
            i + 1,
            data[0], data[1], data[2],
            data[3], data[4], data[5],
            data[6], data[7]
        });
    }
}

public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel();
        model.setRowCount(0);
    }

public void terpilih(int index) throws SQLException {
    ArrayList<Object[]> list = getMhsList();

    nim.setText(list.get(index)[0].toString());
    nama.setText(list.get(index)[1].toString());
    nUTS.setText(list.get(index)[2].toString());
    nUAS.setText(list.get(index)[3].toString());
    nTugas.setText(list.get(index)[4].toString());
}
 
 private void tabelMouseClicked(java.awt.event.MouseEvent evt) {                                   
        int index = jTable1.getSelectedRow();
        try {
            terpilih(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        proses1.setEnabled(true);
        hapus.setEnabled(true);
    } 

 
    /**
     * Creates new form FormNilai
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nUTS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nUAS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nTugas = new javax.swing.JTextField();
        proses = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        tambahlain = new javax.swing.JButton();
        proses1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nUTS1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nUAS1 = new javax.swing.JTextField();
        nTugas1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Form Nilai Mahasiswa");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("NIM");

        nim.addActionListener(this::nimActionPerformed);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Nama");

        nama.addActionListener(this::namaActionPerformed);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Nilai UTS");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Nilai UAS");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Nilai Tugas");

        proses.setText("Proses");
        proses.addActionListener(this::prosesActionPerformed);

        simpan.setText("Simpan");
        simpan.addActionListener(this::simpanActionPerformed);

        tambahlain.setText("Tambah Lain");
        tambahlain.addActionListener(this::tambahlainActionPerformed);

        proses1.setText("Proses");
        proses1.addActionListener(this::proses1ActionPerformed);

        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);

        hapus.setText("Hapus");
        hapus.addActionListener(this::hapusActionPerformed);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("UTS 35%");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("UAS 35%");

        nTugas1.addActionListener(this::nTugas1ActionPerformed);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Tugas 30%");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Nilai Huruf");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Nilai Akhir");

        jTextField11.addActionListener(this::jTextField11ActionPerformed);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Predikat");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Nilai Akhir", "Grade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        keluar.setText("Keluar");
        keluar.addActionListener(this::keluarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(1, 1, 1)
                                            .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nTugas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(proses1)
                                    .addGap(54, 54, 54)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(hapus))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(proses)
                                            .addGap(54, 54, 54)
                                            .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(tambahlain)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(keluar))))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proses)
                            .addComponent(simpan)
                            .addComponent(tambahlain))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(keluar))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proses1)
                    .addComponent(update)
                    .addComponent(hapus))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {                                       
    prosesHitungNilai();

    simpan.setEnabled(true);
    }                                      

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try{
PreparedStatement ps = con.prepareStatement("INSERT INTO mhs(nim,nama,nilai_uts,nilai_uas,nilai_tugas,nilai_akhir,nilai_huruf,predikat)"
                    + "values(?,?,?,?,?,?,?,?) ");
            ps.setString(1, nim.getText());
            ps.setString(2, nama.getText());
            ps.setString(3, nUTS.getText());
            ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText());
            ps.setDouble(6, Double.parseDouble(jTextField11.getText()));
            ps.setString(7, jTextField10.getText()); 
            ps.setString(8, jTextField9.getText());  
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
        }
        try {
            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }                                      

    private void tambahlainActionPerformed(java.awt.event.ActionEvent evt) {                                           
        kosongkanTextField();
        simpan.setEnabled(false);
    }                                          

    private void proses1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (con == null) {
        JOptionPane.showMessageDialog(null, "Koneksi gagal!");
        return;
    }

    if (nim.getText().isEmpty() || nama.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Data belum lengkap!");
        return;
    }

    String updateQuery = "UPDATE mhs SET nim=?, nama=?, nilai_uts=?, nilai_uas=?, nilai_tugas=?, nilai_akhir=?, nilai_huruf=?, predikat=? WHERE nim=?";

    try (PreparedStatement ps = con.prepareStatement(updateQuery)) {

        ps.setString(1, nim.getText());
        ps.setString(2, nama.getText());
        ps.setDouble(3, Double.parseDouble(nUTS.getText()));
        ps.setDouble(4, Double.parseDouble(nUAS.getText()));
        ps.setDouble(5, Double.parseDouble(nTugas.getText()));
        ps.setDouble(6, Double.parseDouble(nUTS1.getText()));
        ps.setString(7, nUAS1.getText());
        ps.setString(8, nTugas1.getText());

        // WHERE nim lama
        ps.setString(9, nim.getText());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Data tidak berhasil diupdate");
    }

    try {
        kosongkanTextField();
        tampilkanDiTabel();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }                                      

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if (con == null) {
        JOptionPane.showMessageDialog(null, "Koneksi gagal!");
        return;
    }

    if (nim.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(null, 
            "Yakin ingin menghapus data?", 
            "Konfirmasi", 
            JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try (PreparedStatement ps = con.prepareStatement("DELETE FROM mhs WHERE nim = ?")) {

        ps.setString(1, nim.getText());
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Mahasiswa berhasil dihapus");

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Mahasiswa tidak berhasil dihapus");
    }

    try {
        kosongkanTextField();
        tampilkanDiTabel();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }                                     

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        int confirm = JOptionPane.showConfirmDialog(
        null, 
        "Yakin ingin keluar?", 
        "Konfirmasi", 
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }

    }                                      

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void nimActionPerformed(java.awt.event.ActionEvent evt) {                                    
        nama.requestFocus();
    }                                   

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {                                     
        nUTS.requestFocus();
    }                                    

    private void nTugas1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        prosesHitungNilai();
        update.setEnabled(true);
    }                                       
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        new FormNilai().setVisible(true);
    });
}

    // Variables declaration - do not modify                     
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nTugas;
    private javax.swing.JTextField nTugas1;
    private javax.swing.JTextField nUAS;
    private javax.swing.JTextField nUAS1;
    private javax.swing.JTextField nUTS;
    private javax.swing.JTextField nUTS1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JButton proses;
    private javax.swing.JButton proses1;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambahlain;
    private javax.swing.JButton update;                   
}
