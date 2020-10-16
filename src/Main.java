/*
 * ------- Program krav ------------
 *
 * Programmet ska ha ett kommandoradsbaserat eller grafiskt användargränssnitt,
 * vilket möjliggör för användaren att välja vilken funktionalitet som skall utföras.
 *
 * Man ska kunna lägga in (Insert) data i databasens tabell via programmet.
 * Man ska kunna uppdatera (Update) enskilda dataposter via programmet.
 * Man ska kunna ta bort (Delete) enskilda dataposter via programmet.
 * Man ska kunna läsa (Select) ifrån databasen in till objekt som representerar den lästa datan.
 * Programmet ska kunna skriva ut alla dataposter från databasen.
 */

import model.WorkoutModel;
public class Main {

    public static void main(String[] args) {


        WorkoutModel workoutModel = new WorkoutModel();
        workoutModel.runProgram();
    }

}


