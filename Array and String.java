class StudentGrade {
    public static void main(String[] args) {

        String[] names = {"Asha", "Balu", "Chitra", "Deepak", "Esha"};

        int[][] marks = {
            {70, 65, 80, 75, 60},
            {85, 78, 72, 80, 76},
            {60, 55, 58, 62, 64},
            {90, 88, 85, 92, 89},
            {50, 45, 48, 52, 55}
        };

        System.out.println("Name\tTotal Marks\tGrade");

        for (int i = 0; i < 5; i++) {
            int totalMarks = 0;

            // Calculate total marks of 5 subjects
            for (int j = 0; j < 5; j++) {
                totalMarks = totalMarks + marks[i][j];
            }

            char grade;
            if (totalMarks >= 400)
                grade = 'A';
            else if (totalMarks >= 300)
                grade = 'B';
            else if (totalMarks >= 250)
                grade = 'C';
            else
                grade = 'D';

            System.out.println(names[i] + "\t" + totalMarks + "\t\t" + grade);
        }
    }
}
