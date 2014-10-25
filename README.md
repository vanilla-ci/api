VanillaCI Api
===

VanillaCI API endpoint. Creates jobs, puts work messages on a RabbitMQ queue.

How To Use
==========

- Download, install, and run RabbitMQ. http://www.rabbitmq.com/download.html
- Compile project then run com.vanillaci.api.ApiApplication
- Run the worker
- Post the following file to the /job url. https://gist.github.com/JoelJ/b0b089fc16c1d800ab04
- Now post to the following URL to run the job: /job/1/start with a json map with the key "value" and any value you want as the request body.


I personally use the following httpie commands:

    http POST :8080/job < job.json
    http POST :8080/job/1/start "value=Hello World"

It's in the very early stages, but this example gives you an idea of what I'm trying to accomplish.


TODO:

Rename jobs to templates.
Create a job that simply wraps a template with default parameters.
When you execute a build, have its parameters simply overwrite the job's parameters if there are any collisions.
