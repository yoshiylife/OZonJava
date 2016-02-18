
class AlreadyRegisteredUserException{
  new init(){}
}

class UnknownUserException{
  new init(){}
}

class SecurityException{
  new init(){}
}

class ObsoleteTicketException{
  new init(){}
}

class InvalidTicketException{
  new init(){}
}

class TimeOutException :* RuntimeException {
  new init() { super=>init(); }
}
