# Lab01_Hystrix

## Instructions:

1. Make 2 Applications, formatting.service and scheduling.service
	-scheduling.service will be called by formatting.service
	-formatting.service will use hystrix to wrap call
2. Update POM of formatting.service to include hystrix

3. Update Java main class to include @EnableHystrix

4. Update REST controller to include fallback method

5. Update REST method to use @HystrixCommand, which will call fallback
