import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ListenersEnfermedades implements ActionListener {

    public Enfermedades enfermedades;

    public ListenersEnfermedades (Enfermedades enf){
        this.enfermedades = enf;
    }

    public void actionPerformed(ActionEvent e) {

        List<String> listaRazas = new ArrayList<>();
        File file = new File("./src/razas.txt");

        if (e.getSource() == enfermedades.getBtnCancelarPraEnfermedades()){
            enfermedades.dispose();

        }

        if(e.getSource() == enfermedades.getBtnBuscarPraEnfermedades()){
            try {
                BufferedReader bf = new BufferedReader(new FileReader(file));

                if(!file.exists()){
                    file.createNewFile();
                }

                String linea;

                linea = bf.readLine();
                while (linea != null){
                    listaRazas.add(linea);
                    linea = bf.readLine();
                }

                for(int i=0;i < listaRazas.size();i++){
                    enfermedades.getCboRaza().addItem(listaRazas.get(i));
                }

            }catch (IOException ex){ex.printStackTrace();}
            catch (Exception ex){ex.printStackTrace();}

            enfermedades.getPanelPrincipal().add(enfermedades.getPnlBuscarEnf(),BorderLayout.CENTER);

            enfermedades.getPnlSurBuscar().add(enfermedades.getBtnAceptarPra());
            enfermedades.getPnlSurBuscar().add(enfermedades.getBtnLimpiarPra());
            enfermedades.getPnlSurBuscar().add(enfermedades.getBtnCancelarPra());

            enfermedades.getPnlPraEnfermedades().setVisible(false);
            enfermedades.getPnlBuscarEnf().setVisible(true);

        }

        if(e.getSource() == enfermedades.getBtnRegistrarPraEnfermedades()){
            enfermedades.getPanelPrincipal().add(enfermedades.getPnlRegistrarEnf(),BorderLayout.CENTER);

            enfermedades.getPnlSurRegEnf().add(enfermedades.getBtnAceptarPra());
            enfermedades.getPnlSurRegEnf().add(enfermedades.getBtnLimpiarPra());
            enfermedades.getPnlSurRegEnf().add(enfermedades.getBtnCancelarPra());

            enfermedades.getPnlPraEnfermedades().setVisible(false);
            enfermedades.getPnlRegistrarEnf().setVisible(true);

        }

        if (e.getSource() == enfermedades.getBtnLimpiarPra()){
            enfermedades.getTxtRazaRegEnf().setText("");
            enfermedades.getTxtNomCmnRegEnf().setText("");
            enfermedades.getTxtNomCienRegEnf().setText("");
            enfermedades.getTextArea().setText(null);
            enfermedades.getCboRaza().setSelectedItem("Selecciona una Raza");

        }

        if(e.getSource() == enfermedades.getBtnCancelarPra()){
            enfermedades.getPanelPrincipal().remove(enfermedades.getPnlBuscarEnf());
            enfermedades.getPanelPrincipal().remove(enfermedades.getPnlRegistrarEnf());
            enfermedades.getTxtRazaRegEnf().setText("");
            enfermedades.getTxtNomCmnRegEnf().setText("");
            enfermedades.getTxtNomCienRegEnf().setText("");
            enfermedades.getCboRaza().removeAllItems();
            enfermedades.getCboRaza().addItem("Selecciona una Raza");
            enfermedades.getCboRaza().setSelectedItem("Selecciona una Raza");
            enfermedades.getTextArea().setText(null);
            enfermedades.getPnlPraEnfermedades().setVisible(true);
            enfermedades.getPnlBuscarEnf().setVisible(false);
            enfermedades.getPnlRegistrarEnf().setVisible(false);

        }

        if(e.getSource() == enfermedades.getBtnAceptarPra()){
            if (enfermedades.getPnlRegistrarEnf().isVisible()) {
                if (!"".equals(enfermedades.getTxtRazaRegEnf().getText()) & !"".equals(enfermedades.getTxtNomCmnRegEnf().getText())
                        & !"".equals(enfermedades.getTxtNomCienRegEnf().getText())) {

                    try{
                        String ruta = "./src/"+enfermedades.getTxtRazaRegEnf().getText()+".txt";
                        File fileRegistro = new File(ruta);

                        if (!fileRegistro.exists()){
                            fileRegistro.createNewFile();
                            JOptionPane.showMessageDialog(null,"Nueva raza registrada");
                        }

                        BufferedWriter bw = new BufferedWriter(new FileWriter(fileRegistro,true));
                        BufferedReader bf = new BufferedReader(new FileReader(fileRegistro));

                        List<String> lsPalabras = new ArrayList<>();
                        String linea;

                        linea = bf.readLine();
                        while ((linea ) != null){
                            String[] palabra = linea.split(": ");
                            lsPalabras.add(palabra[1]);
                            linea = bf.readLine();
                        }

                        if (lsPalabras.contains(enfermedades.getTxtNomCienRegEnf().getText()) &
                                lsPalabras.contains(enfermedades.getTxtNomCmnRegEnf().getText())) {
                            JOptionPane.showMessageDialog(null,"La enfermedad ya ha sido registrada");
                        }else {
                            bw.write("Nombre Científico: " + enfermedades.getTxtNomCienRegEnf().getText() + "\n" +
                                    "Nombre Común: " + enfermedades.getTxtNomCmnRegEnf().getText() + "\n");
                            JOptionPane.showMessageDialog(null,"Nueva Enfermedad Registrada");
                        }

                        bw.flush();
                        bw.close();

                    }catch (IOException ex){ex.printStackTrace();}
                    catch (Exception ex){ex.printStackTrace();}

                } else{
                    JOptionPane.showMessageDialog(null, "No has completado todos los campos");
                }

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                    BufferedReader bf = new BufferedReader(new FileReader(file));

                    if(!file.exists()){
                        file.createNewFile();
                    }

                    String linea;

                    linea = bf.readLine();
                    while (linea != null){
                        listaRazas.add(linea);
                        linea = bf.readLine();
                    }

                    if(listaRazas.contains(enfermedades.getTxtRazaRegEnf().getText()) == false){
                        bw.write(enfermedades.getTxtRazaRegEnf().getText()+"\n");
                        bw.flush();
                    }

                    bw.close();

                }catch (IOException ex){ex.printStackTrace();}
                catch (Exception ex){ex.printStackTrace();}

            }else if (enfermedades.getPnlBuscarEnf().isVisible()) {
                if (enfermedades.getCboRaza().getSelectedItem() != "Selecciona una Raza") {
                    enfermedades.getTextArea().setText(null);
                    try {
                        String ruta = "./src/"+enfermedades.getCboRaza().getSelectedItem()+".txt";
                        File fileBuscar = new File(ruta);

                        if (!fileBuscar.exists()){
                            fileBuscar.createNewFile();
                        }

                        BufferedReader bf = new BufferedReader(new FileReader(fileBuscar));
                        String linea;
                        linea = bf.readLine();

                        while (linea != null){
                            enfermedades.getTextArea().append(linea+"\n");
                            linea = bf.readLine();
                        }

                    }catch (IOException ex){ex.printStackTrace();}
                    catch (Exception ex){ex.printStackTrace();}
                } else {
                    JOptionPane.showMessageDialog(null, "No has elegido una raza");
                }
            }

        }

    }
}
