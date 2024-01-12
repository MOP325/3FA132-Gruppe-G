// import dev.hv.db.dao.ReadingDAO;
// import dev.hv.db.model.Reading;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;

// import javax.ws.rs.core.Response;
// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// public class ReadingResourceTest {

//     private ReadingDAO readingDAO;
//     private ReadingResource readingResource;

//     @BeforeEach
//     public void setUp() {
//         readingDAO = mock(ReadingDAO.class);
//         readingResource = new ReadingResource(readingDAO);
//     }

//     @Test
//     public void testCreateReading() {
//         Reading reading = new Reading(1, 1, 123, "Electric", 100.0, 0, "Test Comment");

//         readingResource.createReading(reading);

//         verify(readingDAO, times(1)).insert(
//                 eq(1), eq(123), eq("Electric"), eq(100.0), eq(0), eq("Test Comment")
//         );
//     }

//     @Test
//     public void testUpdateReading() {
//         int id = 1;
//         Reading reading = new Reading(id, 1, 123, "Electric", 100.0, 0, "Test Comment");

//         readingResource.updateReading(id, reading);

//         verify(readingDAO, times(1)).update(
//                 eq(id), eq(1), eq(123), eq("Electric"), eq(100.0), eq(0), eq("Test Comment")
//         );
//     }

//     @Test
//     public void testGetReadingById() {
//         int id = 1;
//         Reading expectedReading = new Reading(id, 1, 123, "Electric", 100.0, 0, "Test Comment");
//         when(readingDAO.findById(id)).thenReturn(expectedReading);

//         Reading actualReading = readingResource.getReadingById(id);

//         assertEquals(expectedReading, actualReading);
//     }

//     @Test
//     public void testGetAllReadings() {
//         List<Reading> expectedReadings = Arrays.asList(
//                 new Reading(1, 1, 123, "Electric", 100.0, 0, "Test Comment"),
//                 new Reading(2, 2, 456, "Water", 50.0, 1, "Another Comment")
//         );
//         when(readingDAO.findAll()).thenReturn(expectedReadings);

//         List<Reading> actualReadings = readingResource.getAllReadings();

//         assertEquals(expectedReadings, actualReadings);
//     }

//     @Test
//     public void testDeleteReading() {
//         int id = 1;

//         readingResource.deleteReading(id);

//         verify(readingDAO, times(1)).delete(eq(id));
//     }
// }
