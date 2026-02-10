Project Name : Secure Research Dataset Sharing System with Time-Limited Access 

The Hill Climb algorithm is a fast and efficient method specifically applied to route optimization in delivery systems. It works by starting with an initial route and iteratively making small modifications, such as reordering stops, to continuously reduce the total travel time or distance. If a modification improves efficiency, it is accepted, and the process repeats until no further improvements are possible, resulting in a locally optimized route. This approach is computationally lightweight and can adapt quickly to real-time changes like traffic or roadblocks, making it ideal for small to medium-sized delivery networks.


Tech Stack : 
Python  ,
Flask  ,
HTML  ,
CSS  ,
JavaScript ,
MongoDB  ,
AES & RSA Encryption  ,
SHA-256 Hashing


Features

Authentication – Secure login with password + email OTP verification

Role-Based Access Control – Admin, Researcher, Reviewer roles

Hybrid Encryption – AES for data encryption + RSA for key security

Password Security – SHA-256 hashing with salt

Digital Signatures – Ensures dataset integrity and authenticity

API Integration – Backend APIs connected to frontend for dataset upload and controlled sharing

Time-Limited Access – Datasets accessible only within defined validity period



How to Run the Project :

Install dependencies:

pip install -r requirements.txt


Run the Flask application:

python app.py


Open browser and go to:

http://127.0.0.1:5000
