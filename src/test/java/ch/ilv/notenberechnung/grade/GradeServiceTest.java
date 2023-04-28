package ch.ilv.notenberechnung.grade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class GradeServiceTest {

    private GradeService gradeService;
    private final GradeRepository gradeRepositoryMock = mock(GradeRepository.class);

    private final Grade gradeMock = mock(Grade.class);

    @BeforeEach
    void setUp() {
        gradeService = new GradeService(gradeRepositoryMock);
    }

    @Test
    void addgrade() {
        gradeService.addGrade(gradeMock);
        verify(gradeRepositoryMock, times(1)).save(any());
    }

    @Test
    void getallgrade() {
        when(gradeRepositoryMock.findAll()).thenReturn(List.of(gradeMock));
        gradeService.getgrade();
        verify(gradeRepositoryMock, times(1)).findAll();
    }

    @Test
    void getgrade() {
        when(gradeRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(gradeMock));
        gradeService.getgrade(1L);
        verify(gradeRepositoryMock, times(1)).findById(any());
    }

    @Test
    void deletegrade() {
        gradeService.deletegrade(1L);
        verify(gradeRepositoryMock, times(1)).deleteById(any());
    }

    @Test
    void updategrade() {
        gradeService.updateGrade(gradeMock);
        verify(gradeRepositoryMock, times(1)).save(gradeMock);
    }
}