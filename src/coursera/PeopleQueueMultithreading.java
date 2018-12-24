package coursera;


public class PeopleQueueMultithreading extends Thread{ // Наша очередь из сотрудников, наследник класса Thread
        private String [] names;

           PeopleQueueMultithreading(String ... names) {// Конструктор, аргумент- массив имен сотрудников
            this.names = names;
        }

        @Override
        public void run() { // Этот метод будет вызван при старте потока
            for (int i = 0; i < names.length; i++) { // Вывод в цикле с паузой 0.5 сек очередного сотрудника
                System.out.println("Обработаны документы: " + names[i]);
                try {
                    sleep(500); // Задержка в 0.5 сек
                } catch (Exception e) {}
            }
        }


    // Класс для демонстрации работы потока
        public static void main(String[] args) {
            // Создаем две очереди
            PeopleQueueMultithreading queue1 = new PeopleQueueMultithreading("Ivan","Sergunia","Nike","Ferdinand","Vasil");
            PeopleQueueMultithreading queue2 = new PeopleQueueMultithreading("Mari","Lola","Alice","Karin","Ylo");

            System.out.println("Start! "); // Сообщение из главного потока программы
            queue1.start();    //Запускаем одну очередь (дочерний поток)
            queue2.start(); //Запускаем вторую (дочерний поток)
        }

}
