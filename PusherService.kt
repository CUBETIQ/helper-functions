package com.cubetiqs.entize.clinical.helper

import com.pusher.rest.Pusher

class PusherService {
     companion object {
         private val register = Pusher("828744", "25e98978c2b2d6c3ec52", "8de05b4958b86f61d495")
         val instance = register
         fun init() {
             register.setCluster("ap1")
             register.setEncrypted(true)

             print("Pusher: initialized...")
         }
     }
}
