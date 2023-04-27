package ch.ilv.notenberechnung.semester;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class SemesterControllerTest {

    private SemesterService semesterService;
    private final SemesterRepository semesterRepositoryMock = mock(SemesterRepository.class);

    private final  Semester semesterMock = mock(Semester.class);

    @BeforeEach
    void setUp() {
        semesterService = new SemesterService(semesterRepositoryMock);
    }

    @Test
    void createsemester() {
        semesterService.createSemester(String.valueOf(semesterMock));
        verify(semesterRepositoryMock, times(1)).save(any());
    }

    @Test
    void getallsemester() {
        when(semesterRepositoryMock.findAll()).thenReturn(List.of(semesterMock));
        semesterService.getSemester();
        verify(semesterRepositoryMock, times(1)).findAll();
    }

    @Test
    void getsemester() {
        when(semesterRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(semesterMock));
        semesterService.getSemester(1L);
        verify(semesterRepositoryMock, times(1)).findById(any());
    }

    @Test
    void deletesemester() {
        semesterService.deleteSemester(any());
        verify(semesterRepositoryMock, times(1)).deleteById(any());
    }

    @Test
    void updatesemester() {
        semesterService.updateSemester(semesterMock);
        verify(semesterRepositoryMock, times(1)).save(any());
    }
}