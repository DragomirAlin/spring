package ro.dragomiralin.springbatch.customer.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import ro.dragomiralin.springbatch.customer.model.Customer;
import ro.dragomiralin.springbatch.customer.repository.CustomerRepository;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class CustomerImporterConfiguration {
    private CustomerRepository repository;

    @Bean
    public FlatFileItemReader<Customer> reader() {
        FlatFileItemReader<Customer> itemReader=new FlatFileItemReader<>();

        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "email");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }
    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }
    @Bean
    public RepositoryItemWriter<Customer> writer() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, RepositoryItemWriter<Customer> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Customer, Customer> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job importCustomerJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importCustomer", jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
