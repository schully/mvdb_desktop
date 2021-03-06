/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ElKebabHenry
 */

public class AddFrame extends javax.swing.JFrame {

    private void InsertMovieInfo(Movie m) {
        title.setText(String.valueOf(m.getTitle()));
        plot.setText(String.valueOf(m.getPlot()));
        runtime.setText(String.valueOf(m.getRuntime()));
        ageRated.setText(String.valueOf(m.getAge_rated()));
        genre.setText(String.valueOf(m.getGenre()));
        imdbScore.setText(String.valueOf(m.getImdb_score()));
        
    }
    
    private void fetchImdbMovie(){
        String input = String.valueOf(inserId.getText());
        try {
            Movie m = MovieAddService.getMasIn().fetchMovieFromImdb(input);
            InsertMovieInfo(m);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    private void Submit(MovieAddResult result){
        try {
            MovieInfo.getInstance().fetchMovie(result.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form AddFrame
     */
    public AddFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        plot = new javax.swing.JLabel();
        runtime = new javax.swing.JLabel();
        star = new javax.swing.JLabel();
        ageRated = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        inserId = new javax.swing.JTextField();
        imdbScore = new javax.swing.JLabel();
        insertPossessor = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setText("Title");

        plot.setText("Plot");

        runtime.setText("runtime");

        star.setText("★ ");

        ageRated.setText("Pegi");

        genre.setText("Genre");

        inserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inserIdKeyReleased(evt);
            }
        });

        imdbScore.setText("imdbScore");

        insertPossessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPossessorActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertPossessor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inserId, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(imdbScore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star)
                                .addGap(59, 59, 59))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(genre)
                                .addGap(78, 78, 78)
                                .addComponent(plot))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(runtime)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(ageRated, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(title)
                            .addComponent(inserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imdbScore)
                            .addComponent(star))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runtime)
                .addGap(1, 1, 1)
                .addComponent(ageRated)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genre)
                    .addComponent(plot))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(insertPossessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inserIdKeyReleased
        fetchImdbMovie();
    }//GEN-LAST:event_inserIdKeyReleased

    private void insertPossessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPossessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertPossessorActionPerformed

    private void saveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMousePressed
        // TODO add your handling code here:
      
         MovieData formData = new MovieData();
         
         formData.setAgeRated(ageRated.getText());
         formData.setGenre(Arrays.asList(genre.getText().split(",")));
         formData.setImdbScore(Double.parseDouble(imdbScore.getText()));
         formData.setPlot(plot.getText());
         formData.setRuntime(Integer.parseInt(runtime.getText()));
         formData.setTitle(title.getText());
         formData.setPossessor(insertPossessor.getText());
         
        try {
            MovieAddService.getMasIn().submit(formData);
        } catch (Exception ex) {
            Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageRated;
    private javax.swing.JLabel genre;
    private javax.swing.JLabel imdbScore;
    private javax.swing.JTextField inserId;
    private javax.swing.JTextField insertPossessor;
    private javax.swing.JLabel plot;
    private javax.swing.JLabel runtime;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel star;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
