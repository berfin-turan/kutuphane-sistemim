package kutuphaneSistemim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


	
	public class KutuphaneSistemimGUI extends JFrame implements ActionListener{
		
		JPanel mpanel,panel1,panelEkle,panelAra,panelListele,panelSil,panelMenu,butonPanel,formPanel,aramaPanel,silmePanel;
		JButton bEkle,bListele,bAra,bSil,bCıkıs,bMenu,kitapEkleButon,araButon,silmeButon;
		JLabel resim,kitapEkleText,yazarEkleText,isbnEkleText,listeleBaslik,baslik,aramaBaslik,silmeBaslik;
		JTextField kitapAdField,yazarAdField,isbnField,araField,silmeField;
		JTextArea listeAlani,aramaAlani;
		JScrollPane scrollListele,scrollAra;
		 
		public KutuphaneSistemimGUI() {
			
			
			//Pencere oluşturma
			JFrame jf=new JFrame("BT Kütüphane Sistemi");
			jf.setSize(500, 500);
			jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jf.setResizable(false);
			jf.setLocationRelativeTo(null);
			
			//Pencere simgesi oluşturma
			Image simge=Toolkit.getDefaultToolkit().getImage("simge.png");
			jf.setIconImage(simge);
			
			jf.setLayout(new BorderLayout());
			mpanel=new JPanel(new GridLayout(6,1,0,10));
			mpanel.setBackground(new Color(139,69,19));
			jf.add(mpanel,BorderLayout.WEST);
			
			panel1=new JPanel();
			panel1.setBackground(new Color(139,69,19));
			jf.add(panel1,BorderLayout.CENTER);
			
			panel1.setLayout(new CardLayout());
			
			ImageIcon ıo=new ImageIcon("bt.png");
			resim=new JLabel(ıo,JLabel.CENTER);
			panel1.add(resim,"Menü");
			 
			baslik=new JLabel("Kitap Ekleme",JLabel.CENTER);
			panelEkle=new JPanel(new BorderLayout());
			baslik.setFont(new Font("Arial",Font.BOLD,18));
			panelEkle.add(baslik,BorderLayout.NORTH);
			panelEkle.setBorder(new EmptyBorder(20, 20, 20, 20));

			panelEkle.setBackground(new Color(139,69,19));
			
			formPanel=new JPanel(new GridLayout(3,2,0,150));
			formPanel.setBackground(new Color(139,69,19));
			
			kitapEkleText=new JLabel("Kitap Adı : ", SwingConstants.CENTER);
			formPanel.add(kitapEkleText);
			  
			kitapAdField=new JTextField();
			kitapAdField.setBackground(new Color(210, 180, 140) );
			formPanel.add(kitapAdField);
			
			yazarEkleText=new JLabel("Yazar Adı : ", SwingConstants.CENTER);
			formPanel.add(yazarEkleText);
			
			yazarAdField=new JTextField(); 
			yazarAdField.setBackground(new Color(210, 180, 140) );
			formPanel.add(yazarAdField);
			
			isbnEkleText=new JLabel("Isbn No : ", SwingConstants.CENTER);
			formPanel.add(isbnEkleText);
			
			isbnField=new JTextField();
			isbnField.setBackground(new Color(210, 180, 140) );
			formPanel.add(isbnField);
			
			panelEkle.add(formPanel,BorderLayout.CENTER);
			
			kitapEkleButon=new JButton("Kitap Ekle");
			butonPanel=new JPanel();
			butonPanel.setBackground(new Color(139,69,19));
			butonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			kitapEkleButon.setBackground(new Color(210, 180, 140));
			kitapEkleButon.addActionListener(this);
			butonPanel.add(kitapEkleButon);
			
			panelEkle.add(butonPanel,BorderLayout.SOUTH);
			
			panel1.add(panelEkle,"ekle");

			
			panelAra=new JPanel(new BorderLayout());
			aramaBaslik=new JLabel("Kitap Arama",JLabel.CENTER);
			aramaBaslik.setFont(new Font("Arial",Font.BOLD,18));
			panelAra.add(aramaBaslik,BorderLayout.NORTH);
			panelAra.setBackground(new Color(139,69,19));
			
			aramaPanel=new JPanel(new FlowLayout());
			aramaPanel.setBackground(new Color(139,69,19));
			
			araField=new JTextField(15);
			araField.setBackground(new Color(210, 180, 140));
			araButon=new JButton("Ara");
			araButon.addActionListener(this);
			araButon.setBackground(new Color(210, 180, 140));
			
			aramaPanel.add(new JLabel("Aranacak Kelime: "));
			aramaPanel.add(araField);
			aramaPanel.add(araButon);
			
			
			panelAra.add(aramaPanel,BorderLayout.CENTER);
			
			aramaAlani=new JTextArea(23,30);//10 satir 30 karakterlik genişlik
			aramaAlani.setEditable(false);
			aramaAlani.setBackground(new Color(210, 180, 140));
			aramaAlani.setFont(new Font("Arial",Font.PLAIN,14)); 
			
			scrollAra=new JScrollPane(aramaAlani);
			panelAra.add(scrollAra,BorderLayout.SOUTH);
			
			
			panel1.add(panelAra,"ara");
		
			
			
			panelListele=new JPanel(new BorderLayout());
			listeleBaslik=new JLabel("Kitap Listeleme",JLabel.CENTER);
			panelListele.add(listeleBaslik,BorderLayout.NORTH);
			listeleBaslik.setFont(new Font("Arial",Font.BOLD,18));
			panelListele.setBackground(new Color(139,69,19));
			
			listeAlani=new JTextArea();
			listeAlani.setEditable(false);
			listeAlani.setBackground(new Color(139,69,19));
			listeAlani.setFont(new Font("Arial",Font.PLAIN,14));
			
			scrollListele=new JScrollPane(listeAlani);
			panelListele.add(scrollListele,BorderLayout.CENTER);
			
			panel1.add(panelListele,"listele");
			
			
			
			
			
			panelSil=new JPanel(new BorderLayout());
			silmeBaslik=new JLabel("Kitap Silme",JLabel.CENTER);
			panelSil.add(silmeBaslik,BorderLayout.NORTH);
			silmeBaslik.setFont(new Font("Arial",Font.BOLD,18));
			panelSil.setBackground(new Color(139,69,19));
			
			silmePanel=new JPanel(new FlowLayout());
			silmePanel.setBackground(new Color(139,69,19));
			
			silmeField=new JTextField(15);
			silmeField.setBackground(new Color(210, 180, 140));
			silmeButon=new JButton("Silme");
			silmeButon.addActionListener(this);
			silmeButon.setBackground(new Color(210, 180, 140));
			
			silmePanel.add(new JLabel("Silinecek ISBN: "));
			silmePanel.add(silmeField);
			silmePanel.add(silmeButon);
			panelSil.add(silmePanel,BorderLayout.CENTER);
			panel1.add(panelSil,"sil");

			
			
			
			//Sol panele buton ekleme
			bMenu=new JButton("Menü");
			bMenu.addActionListener(this);
			
			bEkle=new JButton("Kitap Ekle");
			bEkle.addActionListener(this);
			
			bListele=new JButton("Kitapları Listele");
			bListele.addActionListener(this);
			
			bAra=new JButton("Kitap Ara");
			bAra.addActionListener(this);
			
			bSil=new JButton("Kitap Sil");
			bSil.addActionListener(this);
			
			bCıkıs=new JButton("Çıkış");
			bCıkıs.addActionListener(this);
			
			//Buton arka plan rengi ayarlama
			bMenu.setBackground(new Color(210, 180, 140));
			bEkle.setBackground(new Color(210, 180, 140));
			bListele.setBackground(new Color(210, 180, 140));
			bAra.setBackground(new Color(210, 180, 140));
			bSil.setBackground(new Color(210, 180, 140));
			bCıkıs.setBackground(new Color(210, 180, 140));
			

			//Butonları sol panele yerleştirme
			mpanel.add(bMenu);
			mpanel.add(bEkle);
			mpanel.add(bListele);
			mpanel.add(bAra);
			mpanel.add(bSil);
			mpanel.add(bCıkıs);

			
			
			//Pencerenin görünürlüğünü ayarlama
			jf.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object komut=e.getSource();
			String kitaplarDosyasi="kitaplar.txt";
			
			
			CardLayout c=(CardLayout)(panel1.getLayout());
			
			if(komut.equals(bEkle)) {
				c.show(panel1, "ekle");
					
			}else if(komut.equals(bMenu)) {
				c.show(panel1, "Menü");
			}else if(komut.equals(bAra)) {
				c.show(panel1, "ara");
			}else if(komut.equals(bListele)) {
				c.show(panel1, "listele");
				
				listeAlani.setText("");
				
				try(Scanner s=new Scanner(new File(kitaplarDosyasi))){
					
					while(s.hasNextLine()) {
						String satir=s.nextLine();
						Kitap k=Kitap.fromString(satir);
						if(k!=null) {
							listeAlani.append("-->"+k.getKitapAd()+" | "+k.getYazarAd()+" | "+k.getIsbn()+"\n");
						}
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Kitap listeleme sırasında hata oluştu:"+ex.getMessage());

				}
				
				
			}else if(komut.equals(bSil)) {
				c.show(panel1, "sil");
			}else if(komut.equals(bCıkıs)) {
				int option=JOptionPane.showConfirmDialog(null,"Çıkış yapmak istediğinize emin misiniz? ",
						"Çıkış",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}else if(komut.equals(kitapEkleButon)) {
				
				String kAd=kitapAdField.getText().trim();
				String yAd=yazarAdField.getText().trim();
				String isbN=isbnField.getText().trim();
				
				if (kAd.isEmpty() || yAd.isEmpty() || isbN.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
			        kitapAdField.setText("");
			        yazarAdField.setText("");
			        isbnField.setText("");
			        return;
			    }

				Kitap k=new Kitap(kAd,yAd,isbN);
				boolean isbnVar=false;
				
				
				try(Scanner input=new Scanner(new File(kitaplarDosyasi))){
					
					while(input.hasNextLine()) {
						String satir=input.nextLine();
						Kitap x=Kitap.fromString(satir);
						if(x != null && x.getIsbn().toLowerCase().equals(isbN)) {
							isbnVar=true;
							break;
						}
						
					}
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null,"Isbn arama sırasında hata oluştu:"+a.getMessage());
				}
				if(isbnVar) {
			        JOptionPane.showMessageDialog(null, "Bu ISBN numarasına sahip kitap zaten var.");
			        kitapAdField.setText("");
			        yazarAdField.setText("");
			        isbnField.setText("");
			        return;
				}
				try(PrintWriter p=new PrintWriter(new FileWriter(kitaplarDosyasi,true))){
					p.println(k.toString());
					JOptionPane.showMessageDialog(null,"Kitap başarıyla eklendi.");
					kitapAdField.setText("");
			        yazarAdField.setText("");
			        isbnField.setText("");
					
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,"Kitap ekleme sırasında hata oluştu:"+a.getStackTrace());

				}
				
				
			}else if(komut.equals(araButon)) {
				
				aramaAlani.setText("");
				String aranan=araField.getText().trim().toLowerCase();

				if(araField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lütfen aranacak kelimeyi girin.");
					return;
				}
				
				boolean bulunduMu=false;
				
				try(Scanner i=new Scanner(new File(kitaplarDosyasi))){
					while(i.hasNextLine()) {
						String satir2=i.nextLine();
						Kitap kitapp=Kitap.fromString(satir2);
						
						if(kitapp != null &&( kitapp.getKitapAd().toLowerCase().contains(aranan)
								|| kitapp.getYazarAd().toLowerCase().contains(aranan)
								|| kitapp.getIsbn().toLowerCase().contains(aranan))) {
							aramaAlani.append("-->"+kitapp.getKitapAd()+" | "+kitapp.getYazarAd()+" | "+kitapp.getIsbn()+"\n");
							bulunduMu=true;
						}
						 
					}
					if(!bulunduMu) {
						JOptionPane.showMessageDialog(null, "Aranan kitap bulunamadı.");
					}
					
					
				}catch(Exception z) {
					JOptionPane.showMessageDialog(null, "Kitap aranırken hata oluştu: "+z.getMessage());
				}
			}else if(komut.equals(silmeButon)) {
				
				File dosya=new File(kitaplarDosyasi);
				File geciciDosya=new File("gecici.txt");
				boolean silindiMi=false;
				
				String silinecekIsbn=silmeField.getText().trim();
				Kitap silinecekKitap=null;
				
				if(silmeField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lütfen silinecek ısbn'yi girin.");
					return;
				}
				try(Scanner scan=new Scanner(dosya)){
					
						while(scan.hasNextLine()) {
							String satir3=scan.nextLine();
							Kitap kitap3=Kitap.fromString(satir3);
							
							if(kitap3 != null && (kitap3.getIsbn().toLowerCase()).equals(silinecekIsbn.toLowerCase())) {
								silinecekKitap=kitap3;
								break;
							}
						}
						
						
					}catch(Exception r) {
						JOptionPane.showMessageDialog(null, "Kitap aranırken hata oluştu: "+r.getMessage());
						return;
					}
				
				
				if(silinecekKitap != null) {
					
					int secim=JOptionPane.showConfirmDialog(null, "Silinecek kitap:\n"+
																	"Ad: "+silinecekKitap.getKitapAd()+"\n"+
																	"Yazar: "+silinecekKitap.getYazarAd()+"\n"+
																	"ISBN: "+silinecekKitap.getIsbn()+"\n\n"+
																	"Bu kitabı silmek istediğinize emin misiniz?","Silme Onayı",JOptionPane.YES_NO_OPTION);
					if(secim!=JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Silme işlemi iptal edildi. ");
						silmeField.setText("");
						return;

					}
					
				
				try(Scanner scan=new Scanner(dosya);
					PrintWriter pw=new PrintWriter(new FileWriter(geciciDosya))){
				
					while(scan.hasNextLine()) {
						String satir3=scan.nextLine();
						Kitap kitap3=Kitap.fromString(satir3);
						
						if(kitap3 != null && (kitap3.getIsbn().toLowerCase()).equals(silinecekIsbn.toLowerCase())) {
							silindiMi=true;//Bu satır es geçilir.
						}else {
							pw.println(satir3);
						}
					}
					
					
				}catch(Exception r) {
					JOptionPane.showMessageDialog(null, "Kitap silinirken hata oluştu: "+r.getMessage());

				}
				if(silindiMi) {
					if(dosya.delete()) {
						geciciDosya.renameTo(dosya);
						JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi.");
						silmeField.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Eski dosya silinemedi.");

					}}
					
				}else {
					JOptionPane.showMessageDialog(null, "Belirtilen ISBN numarasına sahip kitap bulunamadı.");
					silmeField.setText("");


				}
				
				
				
				
				
				
				
			}
			
			
		}

	}



