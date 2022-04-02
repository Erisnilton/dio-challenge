package me.dio;

import me.dio.domain.Bootcamp;
import me.dio.domain.Course;
import me.dio.domain.Developer;
import me.dio.domain.Mentorship;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        // Instanciando os cursos ...
        var course01 = Course
                .create()
                .title("Curso de Java")
                .description("Aprenda Java com Boas práticas de programação!")
                .workload(8);

        var course02 = Course
                .create()
                .title("Inteligência Artificial com Python")
                .description("""
                        Aprenda na prática sobre os algoritmos de Machine Learning para classificação, regressão, regras de associação e agrupamento!
                        """)
                .workload(60);

        var mentorship = Mentorship.create()
                .title("Mentoria Java")
                .description("Duas horas de mentoria com desconto exclusivo e conteúdo avançado!")
                .dateTime(LocalDateTime.of(2022, 4, 18, 18, 0));

        var bootcamp = Bootcamp
                .create()
                .name("Bootcamp Java Developer")
                .description("Aprenda por meio de boas práticas de codificação!");

        bootcamp.add(course01);
        bootcamp.add(course02);
        bootcamp.add(mentorship);

        // Instanciando os devs.

        var devEris = Developer
                .create()
                .name("Eris")
                .subscribeIn(bootcamp);

        info(course01, course02, devEris);

        var devJoao = Developer
                .create()
                .name("João da Silva")
                .subscribeIn(bootcamp);

        info(course01, course02, devJoao);

    }

    // Imprime as informações do bootcamp .
    private static void info(Course course01, Course course02, Developer dev) {
        System.out.printf("Conteúdos Inscritos %s: %s\n", dev.name(), dev.subscribedContent());
        dev.progress(course01);
        dev.progress(course02);

        System.out.println("-");
        System.out.printf("Conteúdos Inscritos %s: %s\n", dev.name(), dev.subscribedContent());
        System.out.printf("Conteúdos Concluidos %s: %s\n", dev.name(), dev.completedContent());
        System.out.println("XP:" + dev.totalXP());

        System.out.println("-------");
    }

}
