from flask import Flask, jsonify, request, render_template
from flask_cors import CORS
from sklearn.linear_model import LinearRegression
import pandas as pd

app = Flask(__name__)
CORS(app, resources={r"/api/*": {"origins": "http://localhost:3000"}})

@app.route('/api/data', methods=['POST'])
def receive_data():
    if request.method == 'POST':
        data = request.json
        weight = data.get('weight')
        height = data.get('height')

        total = weight / (height*height)
        data = pd.read_csv('bodyfat.csv')

        
        X = data[['BMI']]
        y = data['BodyFat']


        model = LinearRegression()

       
        model.fit(X, y)
        bmi_value = [[total]]  
        predicted_bodyfat = model.predict(bmi_value)

        # Convert NumPy array to a Python list
        predicted_bodyfat_list = predicted_bodyfat.tolist()

        response_data = {'total': predicted_bodyfat_list}
        return jsonify(response_data)

if __name__ == '__main__':
    app.run(debug=True)
