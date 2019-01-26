# A Jersey client supporting `https`

When testing a rest service behind `https`, you must be able to create a client that support `https`.

It would be nice if it was easy. When you know how to do it, it isn't too hard.

The trick is to create a `javax.ws.rs.client.Client` and set the `sslContext` as well as 
the `hostnameVerifier()` properly.

## Jersey client factory

The factory below creates a Jersey client.

{% include src/test/java/se/thinkcode/JerseyHttpClientFactory.java %}

## A `TrustManager` that thinks that the world is trustworthy 

The first you need is a `TrustManager` that thrust everything. My implementation looks like this:

{% include src/test/java/se/thinkcode/NoOpTrustManager.java %}

It doesn't do anything and will therefore not stop anything. It is rubbish for anything but testing. If you are looking 
for a secure solution, look somewhere else.

## A `HostnameVerifier` that thinks the best of all hosts

The next thing you need is a `HostnameVerifier` that trust the world. An implantation may look like this:

{% include src/test/java/se/thinkcode/NoOpHostnameVerifier.java %}

As you can see, it trusts anything as it always return true in `verify(()`.

These three pieces will allow you to create a `http` client that supports `https` for testing.

## A test class

This client should be used for testing. I used it in a test that looks like this:

{% include src/test/java/se/thinkcode/CurrencyTradeTest.java %}
    
## Dependencies    
    
The last important component is the dependencies I used for this example. They are declared in the build script:

{% include build.gradle %}

## Conclusion

That it folks, creating a Jersey client that supports `https` is doable when you know how to do it.

## Acknowledgements
                                ]
I would like to thank Malin Ekholm for feedback.

## Resources

* [The source code for this example at GitHub](https://github.com/tsundberg/jersey-https-client)
* [Thomas Sundberg](/blog/about) - author
