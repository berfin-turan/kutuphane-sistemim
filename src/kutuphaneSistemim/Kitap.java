package kutuphaneSistemim;

public class Kitap {

	private String kitapAd;
	private String yazarAd;
	private String isbn;
	
	public Kitap(String ad,String yazar,String isbn){
		this.kitapAd=ad;
		this.yazarAd=yazar;
		this.isbn=isbn;
	}
	
	public String getKitapAd() {
		return kitapAd;
	}
	public String getYazarAd() {
		return yazarAd;
	}
	public String getIsbn() {
		return isbn;
	}
	@Override
	public String toString() {
		return kitapAd+";"+yazarAd+";"+isbn;
	}
	public static Kitap fromString(String satir) {
		String[] parcalar=satir.split(";");
		if(parcalar.length==3) {
			return new Kitap(parcalar[0],parcalar[1],parcalar[2]);
		}else {
			return null;
		}
	}

	
	
}
