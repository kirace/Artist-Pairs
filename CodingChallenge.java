package CodingChallenge;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

//compile with ArtistPair.java and ArtistList.csv

public class CodingChallenge {
  
	public static void main(String[] args) throws IOException {
		final Map<ArtistPair, Integer> artistPairs = new HashMap<ArtistPair, Integer>();
		final Set<ArtistPair> popularArtistPairs = new HashSet<ArtistPair>();
	  
		final Scanner scanner = new Scanner(new FileInputStream("ArtistList.csv"));
		while (scanner.hasNextLine()) {
			final List<String> artistsInLine = artistsFromLine(scanner.nextLine());
			final List<ArtistPair> pairsInLine = makePairs(artistsInLine);
			for (ArtistPair currentPair : pairsInLine) {
				if (artistPairs.containsKey(currentPair)) {
					final Integer newCount = artistPairs.get(currentPair) + 1;
					if (newCount == 50) {
						popularArtistPairs.add(currentPair);
					}
					artistPairs.put(currentPair, newCount);				 
				}
				else{
					artistPairs.put(currentPair, 1);
				}
			}	
		}
		scanner.close();
       
		for (ArtistPair pair : popularArtistPairs) {
			System.out.println(pair);
		}
	}
	
	/**
	 * Returns a List<String> containing the individual artists from a given line
	 * @param line	String of artists separated by commas
	 * @return		List<String> of artists
	 */
	private static List<String> artistsFromLine(String line) {
		 return Arrays.asList(line.split("[,]"));	
	}
    
	/**
	 * Returns a List<ArtistPairs> containing the different pairs of artists from the given List<String>
	 * @param  artists	List<String> of individual artist names
	 * @return			List<ArtistPair> of all pairs of artists
	 */
	private static List<ArtistPair> makePairs(List<String> artists){
		List<ArtistPair> pairs = new ArrayList<ArtistPair>();
		for (int x = 0; x < artists.size() - 1; x++) {
			final String artist1 = artists.get(x);
			for (int y = x + 1; y < artists.size(); y++) {
				final String artist2 = artists.get(y);
				pairs.add(new ArtistPair(artist1, artist2));
			}
		}
		return pairs;
	}
			  
}
