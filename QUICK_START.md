# Quick Start Guide - CamLiveBilliard Website

Get your website live in 15 minutes!

## What You Have

A complete, professional website with:
- ✅ Home page with features and download section
- ✅ Privacy Policy (Google Play required)
- ✅ Terms & Conditions
- ✅ Support page with FAQs
- ✅ Fully responsive design
- ✅ SEO optimized
- ✅ Professional styling

## 3-Step Quick Deploy

### Step 1: Choose Hosting (Pick One)

**Option A: GitHub Pages (Easiest - Free)**
1. Create GitHub account at github.com
2. Create new repository named "camlivebilliard-website"
3. Upload all files from `website` folder
4. Go to Settings > Pages
5. Select "main" branch and Save
6. Done! Your site is at: `https://yourusername.github.io/camlivebilliard-website`

**Option B: Netlify (Fastest - Free)**
1. Go to netlify.com and sign up
2. Drag and drop the `website` folder
3. Done! Your site is live instantly

**Option C: Firebase (Google - Free)**
1. Install: `npm install -g firebase-tools`
2. Run: `firebase login`
3. Run: `firebase init hosting`
4. Run: `firebase deploy`
5. Done!

### Step 2: Update Your URLs

After deployment, update these files with your actual domain:

**In sitemap.xml:**
```xml
Replace: https://www.camlivebilliard.com
With: https://your-actual-domain.com
```

**In robots.txt:**
```
Replace: https://www.camlivebilliard.com/sitemap.xml
With: https://your-actual-domain.com/sitemap.xml
```

**In index.html:**
```html
Find the Google Play button and update the link:
<a href="YOUR_GOOGLE_PLAY_LINK" ...>
```

### Step 3: Add to Google Play Console

1. Go to play.google.com/console
2. Select your app
3. Go to "Store presence" > "Main store listing"
4. Add Website: `https://your-domain.com`
5. Add Privacy Policy: `https://your-domain.com/privacy-policy.html`
6. Save and you're done!

## Customization (Optional)

### Change Colors

Edit `website/css/style.css`:
```css
:root {
    --primary-color: #4F46E5;  /* Your brand color */
    --secondary-color: #10B981; /* Accent color */
}
```

### Update Contact Email

Search and replace in all HTML files:
- Find: `support@camlivebilliard.com`
- Replace: `your-email@yourdomain.com`

### Add Your Logo

Replace the SVG logo in navigation with your image:
```html
<img src="images/your-logo.png" alt="Your App" />
```

## Testing Checklist

Before submitting to Google Play:

- [ ] Visit your homepage - does it load?
- [ ] Click all navigation links - do they work?
- [ ] Test on mobile phone - is it responsive?
- [ ] Check privacy policy page - is it complete?
- [ ] Verify HTTPS is working (green padlock)
- [ ] Test Google Play button link

## Common Issues

**Site not loading?**
- Wait 5-10 minutes for deployment
- Clear browser cache
- Try incognito mode

**Links broken?**
- Check file names match exactly
- Ensure all files are uploaded
- Verify paths are correct

**Mobile looks wrong?**
- Clear mobile browser cache
- Check viewport meta tag exists
- Test on different devices

## What's Next?

1. ✅ Deploy website (you just did this!)
2. ⏭️ Add URLs to Google Play Console
3. ⏭️ Complete app submission
4. ⏭️ Wait for approval (3-7 days)
5. ⏭️ Launch your app!

## Need Help?

- **Detailed deployment**: See `DEPLOYMENT.md`
- **Google Play setup**: See `GOOGLE_PLAY_SETUP.md`
- **General info**: See `README.md`

## Support

Questions? Email: support@camlivebilliard.com

---

**That's it! Your professional website is ready for Google Play Console. 🚀**
