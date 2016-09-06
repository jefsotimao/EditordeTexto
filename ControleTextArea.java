package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControleTextArea extends JFrame implements ActionListener {

	
	//CRIANDO UM EDITOR DE TEXTO
	JTextArea texto;
	
	
	public ControleTextArea(){
		super( "Editor de Texto ");
		
		//Todo JTextArea tem que vir junto com um JScrollPane
		 texto = new JTextArea();
		JScrollPane rolagem = new JScrollPane(texto);
		texto.setFont(new Font("Serif", Font.PLAIN, 26));
		
		JButton botao = new JButton("Abrir Arquivo");
		botao.setFont(new Font("Serif", Font.PLAIN, 26));
		botao.addActionListener(this);
		
		Container c = getContentPane();
		c.add(BorderLayout.CENTER,rolagem); // adiciona a rolangem e o botao no container
		c.add(BorderLayout.NORTH,botao);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		new ControleTextArea();
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		// FILECHOOSER É QUANDO CLICA EM ABRIR ARQUIVO E ABRE O LEQUE DE OPCOES PRA ABRIR OS ARQ.
		JFileChooser chose = new JFileChooser();
		chose.showOpenDialog(this); // ABRE AS OPCOES DO CHOSE, (DESTE ) FILECHOOSER
		File file = chose.getSelectedFile(); // PEGA O ARQUIVO SELECIONADO COM A CLASSE FILE 
		
		// COLOCADO NUM TRY CASO TENTE ABRIR UM ARQUIVO INVALIDO
		try{
			Path path = Paths.get(file.getAbsolutePath()); // USA A CLASE PATH PRA PEGAR O CAMINHO BSOLUTO DO ARQUIVO SELECIONADO
			String retorno = new String(Files.readAllBytes(path)); // CRIA UMA STRING QUE RECEBE O RETORNO DOS BYTES DO PATH
			texto.setText(retorno); // O TEXTO VAI SETAR COMO TEXTO O ARQUIVO DE RETORNO
			
		}catch (Exception erro){
			JOptionPane.showMessageDialog(this,"Arquivo invalido");
		}
		
	}

}
