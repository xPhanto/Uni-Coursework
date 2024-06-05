package lab8;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//ALREADY IMPLEMENTED; DO NOT MODIFY 
//NO NEED TO SUBMIT THIS FILE

/*
 * Tests included in this class serve as documentation on how instances of a
 * song collect work.
 * 
 * Be sure to also read the Lab instructions PDF carefully
 * 
 * Programming IDEs such as Eclipse are able to fix such compilation errors for
 * you. However, you are advised to follow the guidance as specified in the
 * written Lab instructions PDF to fix these compilation errors manually,
 * because: 1) it helps you better understand how the intended classes and
 * methods work together; and 2) you may be tested in a written test or exam
 * without the assistance of IDEs.
 * 
 */

public class JunitTest_SongCollectionTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_0_1_staticFields() {
		try {
			Field[] fields = SongCollection.class.getDeclaredFields();

			int nStatic = 0;
			for (Field f : fields) {
				int mod = f.getModifiers();
				if (Modifier.isStatic(mod)) {
					nStatic++;
				}
			}
			assertEquals("there should be no static fields", 0, nStatic);
		} catch (Exception x) {
			fail("exception occurred trying to get the fields of this class");
		}
	}

	/*
	 * Recommended exercises: Visualizing and tracing (on both debugger and paper)
	 * on how objects are created and manipulated in each test would be extremely
	 * valuable for reinforcing your understanding.
	 */
	@Test
	public void test_2_0_() {

		SongCollection collection1 = new SongCollection("FirstCollection");

		String collectionName = collection1.getListName();
		String expCollectionName = "FirstCollection";
		String errorMsg1 = String.format("\n Test getListName failed. Returned (%s) " + "but correct is  (%s)",
				collectionName, expCollectionName);
		assertEquals(errorMsg1, expCollectionName, collectionName);

		int collectionSize = collection1.getListofSongs().size();
		int expCollectionSize = 0;
		String errorMsg2 = String.format(
				"\n Test constructor failed. Returned collection size  (%d) " + "but correct is  (%d)", collectionSize,
				expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		collection1.setListName("SecondCollection");
		collectionName = collection1.getListName();
		expCollectionName = "SecondCollection";
		errorMsg1 = String.format("\n Test setListName failed to change the name of the collections. Returned (%s) "
				+ "but correct is  (%s)", collectionName, expCollectionName);
		assertEquals(errorMsg1, expCollectionName, collectionName);



	}

	@Test
	public void test_2_1_() {

		SongCollection collection1 = new SongCollection("FirstCollection");

		Song s1 = new Song("Bird Set Free", "Sia", "This Is Acting", 2016, 252, 1.21);
		Song s2 = new Song("Fight Song", "Rachel Platten", "", 2015, 204, 1.25);
		Song s3 = new Song("Baby One More Time", "Britney Spears", "", 1999, 210, 1.29);
		Song s4 = new Song("One Million Bullets", "Sia", "This Is Acting", 2016, 250, 1.39);
		Song s5 = new Song("Under Stars", "Amy Macdonald", "Under Stars", 2017, 221, 1.79);

		List<Song> alist = new ArrayList<>();
		alist.add(s1);
		alist.add(s2);
		alist.add(s3);
		alist.add(s4);
		int collectionSize = collection1.getListofSongs().size();
		int expCollectionSize = 0;
		String errorMsg2 = String.format(
				"\n Test constructor failed. Returned collection size  (%d) " + "but correct is  (%d)", collectionSize,
				expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		// add list of song to the collection
		collection1.addSongs(alist);

		collectionSize = collection1.getListofSongs().size();
		expCollectionSize = 4;
		errorMsg2 = String
				.format("\n Test addSongs failed to add song to the collection. Returned collection size  (%d) "
						+ "but correct is  (%d)", collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		// remove song from the collection
		collection1.removeSong(s4);
		// verify that the song got deleted
		collectionSize = collection1.getListofSongs().size();
		expCollectionSize = 3;
		errorMsg2 = String
				.format("\n Test addSongs failed to add song to the collection. Returned collection size  (%d) "
						+ "but correct is  (%d)", collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		// Try to remove a song that does not exist in the collection, there is no
		// effect
		collection1.removeSong(s5);
		collectionSize = collection1.getListofSongs().size();
		expCollectionSize = 3;
		errorMsg2 = String
				.format("\n Test addSongs failed to add song to the collection. Returned collection size  (%d) "
						+ "but correct is  (%d)", collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

	}

	@Test
	public void test_3_0_() {

		SongCollection collection1 = new SongCollection("FirstCollection");

		Song s1 = new Song("Bird Set Free", "Sia", "This Is Acting", 2016, 252, 1.21);
		Song s2 = new Song("Fight Song", "Rachel Platten", "", 2015, 204, 1.25);
		Song s3 = new Song("Baby One More Time", "Britney Spears", "", 1999, 210, 1.29);
		Song s4 = new Song("One Million Bullets", "Sia", "This Is Acting", 2016, 250, 1.39);
		Song s5 = new Song("Under Stars", "Amy Macdonald", "Under Stars", 2017, 221, 1.79);
		Song s6 = new Song("Song Of Ocarina ", "Diego Modena", "", 1991, 215, 0.79);

		List<Song> alist = new ArrayList<>();
		alist.add(s1);
		alist.add(s2);
		alist.add(s3);
		alist.add(s4);
		List<Song> blist = new ArrayList<>();
		blist.add(s6);
		blist.add(s5);

		// add list of song to the collection
		collection1.addSongs(alist);

		int collectionSize = collection1.getListofSongs().size();
		int expCollectionSize = 4;
		String errorMsg2 = String
				.format("\n Test addSongs failed to add song to the collection. Returned collection size  (%d) "
						+ "but correct is  (%d)", collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		// test the copy constructor
		SongCollection collection2 = new SongCollection(collection1);
		// change the name of collection2
		collection2.setListName("MyCopyCollection");
		String collectionName = collection2.getListName();
		String expCollectionName = "MyCopyCollection";
		String errorMsg1 = String.format(
				"\n Test new collection created with new name failed. Returned (%s) " + "but correct is  (%s)",
				collectionName, expCollectionName);
		assertEquals(errorMsg1, expCollectionName, collectionName);

		collectionSize = collection2.getListofSongs().size();
		expCollectionSize = 4;
		errorMsg2 = String.format(
				"\n Test copy constructor creating new collection with same number of songs. Returned collection size  (%d) "
						+ "but correct is  (%d)",
				collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);

		// test if the song inside the list

		assertTrue("Collection should contain this Song", collection1.contains(s3));
		assertTrue("Collection should contain this Song", collection1.contains(s4));
		assertFalse("Collection should not contain this Song", collection1.contains(s5));

		// remove the song then check if it inside the collection
		collection1.removeSong(s3);
		assertFalse("Collection should not contain this Song", collection1.contains(s3));

		// The second collection should contain the song
		assertTrue("Collection should contain this Song", collection2.contains(s3));

		// add more songs
		collection1.addSongs(blist);

		collectionSize = collection1.getListofSongs().size();
		expCollectionSize = 5;
		errorMsg2 = String.format(
				"\n Test add more song to collection failed. Returned collection size  (%d) " + "but correct is  (%d)",
				collectionSize, expCollectionSize);
		assertEquals(errorMsg2, expCollectionSize, collectionSize);
		// collection1 contain this song
		assertTrue("Collection should contain this Song", collection1.contains(s5));

		assertFalse("Collection should not contain this Song", collection2.contains(s5));

	}

	@Test
	public void test_4_0_() {
		SongCollection collection1 = new SongCollection("FirstCollection");

		Song s1 = new Song("Bird Set Free", "Sia", "This Is Acting", 2016, 252, 1.21);
		Song s2 = new Song("Fight Song", "Rachel Platten", "", 2015, 204, 1.25);
		Song s3 = new Song("Baby One More Time", "Britney Spears", "", 1999, 210, 1.29);
		Song s4 = new Song("One Million Bullets", "Sia", "This Is Acting", 2016, 250, 1.39);
		Song s5 = new Song("Under Stars", "Amy Macdonald", "Under Stars", 2017, 221, 1.79);
		Song s6 = new Song("Song Of Ocarina", "Diego Modena", "", 1991, 215, 0.79);
		Song s7 = new Song("Alive", "Sia", "This Is Acting", 2016, 554, 1.22);
		Song s8 = new Song("Sometimes", "Britney Spears", "Baby One More Time", 1999, 345, 1.45);
		Song s9 = new Song("Moonlight Reggae", "Diego Modena", "", 2010, 854, 3.45);

		List<Song> alist = new ArrayList<>();
		alist.add(s9);
		alist.add(s8);
		alist.add(s7);
		alist.add(s6);
		alist.add(s5);
		alist.add(s4);
		alist.add(s3);
		alist.add(s2);
		alist.add(s1);

		List<Song> britneyList = new ArrayList<>();
		britneyList.add(s3);
		britneyList.add(s8);
		List<Song> sia = new ArrayList<>();
		sia.add(s1);
		sia.add(s4);
		sia.add(s7);

		collection1.addSongs(alist);

		// test if the artist in the collection

		assertTrue("This artist in the collection", collection1.inSongCollection("Britney Spears"));
		assertFalse("This artist is not in the collection", collection1.inSongCollection("Jennifer Lopez "));

		// test getSongsforArtist

		for (Song s : britneyList) {
			assertTrue("test getSongsforArtist failed should be in the return list from ",
					collection1.getSongsforArtist("Britney Spears").contains(s));

		}

		for (Song s : sia) {
			assertTrue("test getSongsforArtist failed should be in the return list from ",
					collection1.getSongsforArtist("Sia").contains(s));

		}

	}

	@Test
	public void test_5_0_() {
		SongCollection collection1 = new SongCollection("Collection1");
		SongCollection collection2 = new SongCollection("Collection2");
		SongCollection collection3 = new SongCollection("Collection3");
		SongCollection collection4 = new SongCollection("Collection4");

		Song s1 = new Song("Bird Set Free", "Sia", "This Is Acting", 2016, 252, 1.21);
		Song s2 = new Song("Fight Song", "Rachel Platten", "", 2015, 204, 1.25);
		Song s3 = new Song("Baby One More Time", "Britney Spears", "", 1999, 210, 1.29);
		Song s4 = new Song("One Million Bullets", "Sia", "This Is Acting", 2016, 250, 1.39);
		Song s5 = new Song("Under Stars", "Amy Macdonald", "Under Stars", 2017, 221, 1.79);
		Song s6 = new Song("Song Of Ocarina", "Diego Modena", "", 1991, 215, 0.79);
		Song s7 = new Song("Alive", "Sia", "This Is Acting", 2016, 554, 1.22);
		Song s8 = new Song("Sometimes", "Britney Spears", "Baby One More Time", 1999, 345, 1.45);
		Song s9 = new Song("Moonlight Reggae", "Diego Modena", "", 2010, 854, 3.45);

		List<Song> alist = new ArrayList<>();
		List<Song> blist = new ArrayList<>();
		List<Song> clist = new ArrayList<>();
		List<Song> dlist = new ArrayList<>();
		alist.add(s9);
		alist.add(s8);
		alist.add(s7);
		alist.add(s6);
		alist.add(s5);
		alist.add(s4);
		alist.add(s3);
		alist.add(s2);
		alist.add(s1);
		blist.add(s9);
		clist.add(s7);
		clist.add(s6);
		clist.add(s5);
		clist.add(s4);
		dlist.add(s9);
		dlist.add(s8);
		dlist.add(s7);
		dlist.add(s6);

		// test the totalListeningTime
		collection1.addSongs(alist);
		collection2.addSongs(blist);
		collection3.addSongs(clist);
		collection4.addSongs(dlist); collection4.addSongs(alist);
		collection4.addSongs(clist); collection4.addSongs(blist);
		collection4.addSongs(alist);
		collection4.addSongs(clist); collection4.addSongs(blist);
		
		String collectionListingtime = collection1.totalListeningTime();
		 
		String expcollectionListingtime = "Total Listening Time: 0:51:45";
		String errorMsg1 = String.format(
				"\n Test totalListeningTime failed. Returned (%s) " + "but correct is  (%s)",
				collectionListingtime, expcollectionListingtime);
		assertEquals(errorMsg1, expcollectionListingtime, collectionListingtime);
		
		
		collectionListingtime = collection2.totalListeningTime();
		 
		expcollectionListingtime = "Total Listening Time: 0:14:14";
		errorMsg1 = String.format(
				"\n Test totalListeningTime failed. Returned (%s) " + "but correct is  (%s)",
				collectionListingtime, expcollectionListingtime);
		assertEquals(errorMsg1, expcollectionListingtime, collectionListingtime);
		
		
		collectionListingtime = collection3.totalListeningTime();
		 
		expcollectionListingtime = "Total Listening Time: 0:20:40";
		errorMsg1 = String.format(
				"\n Test totalListeningTime failed. Returned (%s) " + "but correct is  (%s)",
				collectionListingtime, expcollectionListingtime);
		assertEquals(errorMsg1, expcollectionListingtime, collectionListingtime);
		
		collectionListingtime = collection4.totalListeningTime();

		expcollectionListingtime = "Total Listening Time: 3:26:06";
		errorMsg1 = String.format(
				"\n Test totalListeningTime failed. Returned (%s) " + "but correct is  (%s)",
				collectionListingtime, expcollectionListingtime);
		assertEquals(errorMsg1, expcollectionListingtime, collectionListingtime);

	}

}
