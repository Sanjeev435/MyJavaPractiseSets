### Purpose:
  * Allows for object level access control by acting as a pass through entity or a placeholder object.

#### Use When 
  * The object being represented is external to the system
  * Objects need to be created on demand.
  * Access control for the original object is required.
  * Added functionality is required when an object is accessed.
  

#### Advantages & Disadvantages
Proxy implementation is bound to the Message interface and therefore hard to reuse.
Proxy logic is often quite generic. Typical use-cases for proxies include caching, access to remote objects or lazy loading.
However, a proxy needs to implement a specific interface (and its methods). This contradicts with re-usability
