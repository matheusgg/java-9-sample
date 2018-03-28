package br.com.sample;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class FlowSample {

    public static void main (final String... args) throws InterruptedException {
        //        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Processando os itens em um ThreadPool diferente. Cada subscriber pode processar 1 item por vez
        //        final SubmissionPublisher<String> publisher = new SubmissionPublisher<>(executorService, 1);
        // O método consume do SubmissionPublisher abstrai toda a logica de um Subscriber
        //        publisher.consume(item -> {
        //            final String thread = Thread.currentThread().getName();
        //            System.out.println(thread + " - " + item);
        //        });
        //
        //        publisher.consume(item -> {
        //            final String thread = Thread.currentThread().getName();
        //            System.out.println(thread + " - " + item);
        //        });
        //
        //        publisher.submit("Item de Teste 1");
        //        publisher.submit("Item de Teste 2");
        //        publisher.submit("Item de Teste 3");
        //        publisher.submit("Item de Teste 4");
        //
        //        TimeUnit.SECONDS.sleep(5);
        //        executorService.shutdown();

        try (final SubmissionPublisher<NF> publisher = new SubmissionPublisher<>();
             final NFFilterProcessor processor = new NFFilterProcessor()) {
            processor.subscribe(new NFSubscriber());
            publisher.subscribe(processor);

            List.of(new NF("Client 1", "Book 1", 100),
                    new NF("Client 3", "Book 2", 200),
                    new NF("Client 2", "Book 3", 300),
                    new NF("Client 7", "Book 4", 400),
                    new NF("Client 4", "Book 5", 500),
                    new NF("Client 8", "Book 6", 0))
                    .forEach(publisher::submit);

            TimeUnit.SECONDS.sleep(20);
        }
    }

    static class NFFilterProcessor extends SubmissionPublisher<NF> implements Flow.Processor<NF, NF> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe (final Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext (final NF item) {
            if (item.amount > 0) {
                super.submit(item);
            } else {
                System.out.println("Price is less than or equal to 0 - " + item);
            }
            this.subscription.request(1);
        }

        @Override
        public void onError (final Throwable throwable) {
            System.err.println(throwable.getMessage());
        }

        @Override
        public void onComplete () {
            System.out.println("NFFilterProcessor Done!");
            super.close();
        }
    }

    static class NFSubscriber implements Flow.Subscriber<NF> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe (final Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext (final NF item) {
            ExternalWS.emit(item);
            this.subscription.request(1);
        }

        @Override
        public void onError (final Throwable throwable) {
            System.err.println(throwable.getMessage());
        }

        @Override
        public void onComplete () {
            System.out.println("NFSubscriber Done!");
        }
    }

    static class NF {

        private String client;

        private String book;

        private double amount;

        public NF (final String client, final String book, final double amount) {
            this.client = client;
            this.book = book;
            this.amount = amount;
        }

        @Override
        public String toString () {
            final StringBuilder sb = new StringBuilder("NF{");
            sb.append("client='").append(client).append('\'');
            sb.append(", book='").append(book).append('\'');
            sb.append(", amount=").append(amount);
            sb.append('}');
            return sb.toString();
        }
    }

    static class ExternalWS {

        public static void emit (final NF nf) {
            try {
                final String thread = Thread.currentThread().getName();
                System.out.println(thread + " - Starting... " + nf);
                TimeUnit.SECONDS.sleep(2);
                System.out.println(thread + " - Done!");
            } catch (final InterruptedException e) {
                System.err.println("Error! " + e.getMessage());
            }
        }
    }
}
