package ch.ilv.notenberechnung.semester;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class SemesterControllerTest {

    private SemesterService semesterService;

    private SemesterController semesterController = mock(SemesterController.class);
    private final SemesterRepository semesterRepositoryMock = mock(SemesterRepository.class);

    private final  Semester semesterMock = mock(Semester.class);

    @BeforeEach
    void setUp() {
        semesterService = new SemesterService(semesterRepositoryMock);
    }
    @Test
    void createsemester() {
        semesterController.createsemester(any());
        verify(semesterController, times(1)).createsemester(any());
    }

    @Test
    void getallsemester() {
        when(semesterRepositoryMock.findAll()).thenReturn(List.of(semesterMock));
        semesterController.getsemester();
        verify(semesterController, times(1)).getsemester();
    }

    @Test
    void getsemester() {
        when(semesterRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(semesterMock));
        semesterController.getsemester(any());
        verify(semesterController, times(1)).getsemester(any());
    }

    @Test
    void deletesemester() {
        semesterController.deletesemester(any());
        verify(semesterController, times(1)).deletesemester(any());
    }

    @Test
    void updatesemester() {
        semesterController.updatesemester(semesterMock);
        verify(semesterController, times(1)).updatesemester(any());
    }
}