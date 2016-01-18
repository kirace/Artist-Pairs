package CodingChallenge;

public class ArtistPair {
	private String artist1;
	private String artist2;
	
	public ArtistPair(String artist1, String artist2){
		this.artist1 = artist1;
		this.artist2 = artist2;
	}
	
	public String getArtist1(){
		return artist1;
	}
	
	public String getArtist2(){
		return artist2;
	}
	
	public String toString(){
		return artist1 + " , " + artist2;
	}

	@Override
	public boolean equals(Object other){
		ArtistPair ap = (ArtistPair) other;
		if((artist1.equals(ap.getArtist1()) && artist2.equals(ap.getArtist2())) || 
		 (artist1.equals(ap.getArtist2()) && artist2.equals(ap.getArtist1()))){
			return true;
		}
		else{ 
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return artist1.hashCode() + artist2.hashCode();
	}
}
