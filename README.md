# freelancer_portal
## Purpose of this branch 
This branch purposed for deploy Balda's __backend__ on Heroku.  

## What I did
Heroku can deploy project from specified branch of Git repository and only on one language (as I understood).   
Heroku requires similar project structure for Java applications (it means all folders directly are in root directory and _pom.xml_ too) and different structure for JS project like frontend.  
So I decided to split actual branch (it names *feature-Chat*) on 2 branches - *backend-only* (already done) and *frontend-only*(didn't done) and deploy each of them separately.

## How to test
Heroku ask to get name of my App, in that case it _balda-play_ (perhaps I'll rename it further) and after that forms domain name.  
It forms like that: App name + ".herokuapp.com". So full domain is *balda-play.herokuapp.com*.   

## Where It works 
For now I deployed only backend part of **Balda** which is [here](https://balda-play.herokuapp.com/).  
It will react only on HTTP requests and return row json as a response. For test functionality enter that URL: `https://balda-play.herokuapp.com/api/get/users` which returns all users of Balda.
