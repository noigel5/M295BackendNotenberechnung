package ch.ilv.notenberechnung;

import ch.ilv.notenberechnung.semester.Semester;
import ch.ilv.notenberechnung.semester.SemesterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DBTests {

    @Autowired
    private SemesterRepository semesterRepository;

    @Test
    void insertVehicle() {
        Semester semester = new Semester();
        semester.setName("test");
        this.semesterRepository.save(semester);
        Assertions.assertNotNull(semester.getId());
        this.semesterRepository.deleteById(semester.getId());
        Assertions.assertEquals(this.semesterRepository.findById(semester.getId()), Optional.empty());
    }
}
