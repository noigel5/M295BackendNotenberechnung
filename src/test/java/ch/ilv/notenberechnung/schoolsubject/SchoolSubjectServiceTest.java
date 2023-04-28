package ch.ilv.notenberechnung.schoolsubject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SchoolSubjectServiceTest {

    private SchoolSubjectService schoolSubjectService;
    private final SchoolSubjectRepository schoolSubjectRepositoryMock = mock(SchoolSubjectRepository.class);

    private final SchoolSubject schoolSubjectMock = mock(SchoolSubject.class);

    @BeforeEach
    void setUp() {
        schoolSubjectService = new SchoolSubjectService(schoolSubjectRepositoryMock);
    }

    @Test
    void addschoolsubject() {
        schoolSubjectService.createSchoolSubject(schoolSubjectMock);
        verify(schoolSubjectRepositoryMock, times(1)).save(any());
    }

    @Test
    void getallschoolsubject() {
        when(schoolSubjectRepositoryMock.findAll()).thenReturn(List.of(schoolSubjectMock));
        schoolSubjectService.getSchoolSubject();
        verify(schoolSubjectRepositoryMock, times(1)).findAll();
    }

    @Test
    void getschoolsubject() {
        when(schoolSubjectRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(schoolSubjectMock));
        schoolSubjectService.getSchoolSubject(any());
        verify(schoolSubjectRepositoryMock, times(1)).findById(any());
    }

    @Test
    void deleteschoolsubject() {
        schoolSubjectService.deleteSchoolSubject(1L);
        verify(schoolSubjectRepositoryMock, times(1)).deleteById(any());
    }

    @Test
    void updateschoolsubject() {
        schoolSubjectService.updateSchoolSubject(schoolSubjectMock);
        verify(schoolSubjectRepositoryMock, times(1)).save(any());
    }
}