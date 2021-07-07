package coursera.thread;


public class PeopleQueueMultithreading extends Thread { // Наша очередь из сотрудников, наследник класса Thread
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
            PeopleQueueMultithreading queue1 = new PeopleQueueMultithreading("1 Ivan","2 Sergunia","3 Nike","4 Ferdinand","5 Vasil");
            PeopleQueueMultithreading queue2 = new PeopleQueueMultithreading("1 Mari","2 Lola","3 Alice","4 Karin","5 Ylo");

            System.out.println("Start! "); // Сообщение из главного потока программы
            queue1.start();    //Запускаем одну очередь (дочерний поток)
            queue2.start(); //Запускаем вторую (дочерний поток)
        }

}
