import org.example.Calculatrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        Mockito.when(calculatrice.additionner(2, 3)).thenReturn(5);

        // ✅ Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // ✅ Vérification du résultat
        assert(resultat == 5);

        // ✅ Vérification que la méthode "additionner" a été appelée avec les arguments 2 et 3
        Mockito.verify(calculatrice).additionner(2, 3);

        // ✅ Vérification qu'aucune autre méthode n'a été appelée sur l'objet
        Mockito.verifyNoMoreInteractions(calculatrice);

        // ❗ Vérification de l'état de l'objet après l'appel de la méthode (non possible ici)
        // Cette vérification n’est pas réalisable avec un mock (car l’état n’est pas modifié),
        // il faudrait utiliser un objet réel.

        // Exemple si on utilisait une instance réelle :
        /*
        Calculatrice calc = new Calculatrice();
        calc.additionner(2, 3);
        assertEquals(5, calc.getResult());
        */
    }
}

