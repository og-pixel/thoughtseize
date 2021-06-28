package com.miloszjakubanis.thoughtseize.jobs

enum JobState:
  case PREPARING 
  case READY
  case WORKING
  case FINISHED
  case UNSUCCESSFUL