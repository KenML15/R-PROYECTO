import java.util.HashSet;
import java.util.Set;

public class OperacionesConjuntos {
    public static Set<String> union(Set<String> a, Set<String> b){
        Set<String> nuevoconjunto = new HashSet<>(a);
        nuevoconjunto.addAll(b);

        return nuevoconjunto;
    }

    public static Set<String> intersection(Set<String> a, Set<String> b) {
        Set<String> nuevoconjunto = new HashSet<>(a);
        nuevoconjunto.retainAll(b);
        return nuevoconjunto;
    }


    public static Set<String> difference(Set<String> a, Set<String> b) {
        Set<String> nuevoconjunto = new HashSet<>(a);
        nuevoconjunto.addAll(b);
        nuevoconjunto.removeAll(b);

        return nuevoconjunto;
    }

    public static void main(String[] args) {
        Set<String> robotics = new HashSet<>();
        Set<String> programming = new HashSet<>();

        robotics.add("Ana");
        robotics.add("Carlos");
        robotics.add("Luis");

        programming.add("Luis");
        programming.add("Maria");
        programming.add("Pedro");

        Set<String> u = union(robotics, programming);
        Set<String> i = intersection(robotics, programming);
        Set<String> onlyRobotic = difference(robotics, programming);
        Set<String> onlyProgramming = difference(programming, robotics);

        System.out.println("Robótica: " + robotics);
        System.out.println("Programación: " + programming);
        System.out.println("Unión: " + u);
        System.out.println("Intersección: " + i);
        System.out.println("Solo en Robótica: " + onlyRobotic);
        System.out.println("Solo en Programación: " + onlyProgramming);

    }
}
