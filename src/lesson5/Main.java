package lesson5;

public class Main {
    public static void main(String[] args) {
        Person worker = new Person("Samoilenko Aleksey Aleksandrivich", "ingener", "samoilenkoaa1990@mail.ru", "89263063356", "60000", 30);

        worker.printPerson();



        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "military", "ivivan@mailbox.com", "892312314", "30000", 30);
        persArray[1] = new Person("Petrov Bob", "doctor", "ivivan@mail.com", "892312311", "40000", 29);
        persArray[2] = new Person("Smirnov Sasha", "programmer", "iv@mailbox.com", "892312312", "50000", 41);
        persArray[3] = new Person("Sidorov Leisha", "singer", "iviva@mailbox.com", "892312315", "60000", 39);
        persArray[4] = new Person("Savenkov Sergey", "actor", "ivivan@box.com", "892312316", "70000", 44);


        for (Person x : persArray) {
            if (x.getAge() > 40) {
                x.printPerson();

            }

        }

    }
}



