# 🚀 Deployment Checklist

## Pre-Deployment Tasks

### 1. Update Content ⚠️ REQUIRED

- [ ] **Update Email Addresses**
  - Search for: `@camlivebilliard.com`
  - Replace with your real email in:
    - [ ] index.html (footer)
    - [ ] privacy-policy.html (contact section)
    - [ ] terms-conditions.html (contact section)
    - [ ] support.html (contact section)

- [ ] **Update Google Play Store Link**
  - File: `index.html`
  - Find: `https://play.google.com/store`
  - Replace with: Your actual Play Store URL
  - Location: Download section button

- [ ] **Update Domain References**
  - Search for: `www.camlivebilliard.com`
  - Replace with your actual domain
  - Files to check:
    - [ ] index.html (meta tags)
    - [ ] privacy-policy.html
    - [ ] terms-conditions.html
    - [ ] support.html

### 2. Test Locally ✅

- [ ] **Test Homepage**
  - [ ] All sections load correctly
  - [ ] Navigation works
  - [ ] Mobile menu opens/closes
  - [ ] All links work
  - [ ] Images display
  - [ ] Animations work

- [ ] **Test Legal Pages**
  - [ ] Privacy policy displays correctly
  - [ ] Terms & conditions displays correctly
  - [ ] Support page displays correctly
  - [ ] Navigation works on all pages
  - [ ] Footer links work

- [ ] **Test Score Display**
  - [ ] score.html loads
  - [ ] Control panel works
  - [ ] Manual score updates work
  - [ ] Layout selector works
  - [ ] Demo mode works (?demo=true)
  - [ ] OBS mode works (?obs=true)

- [ ] **Test Mobile Responsiveness**
  - [ ] Test on phone screen size
  - [ ] Test on tablet screen size
  - [ ] Mobile menu works
  - [ ] Score display is responsive
  - [ ] All text is readable

- [ ] **Test Different Browsers**
  - [ ] Chrome
  - [ ] Firefox
  - [ ] Safari
  - [ ] Edge

### 3. Optimize Files 📦

- [ ] **Check File Sizes**
  - [ ] CSS files are minified (optional)
  - [ ] JavaScript files are minified (optional)
  - [ ] Images are optimized (if you add any)

- [ ] **Verify All Files Present**
  ```
  ✅ index.html
  ✅ privacy-policy.html
  ✅ terms-conditions.html
  ✅ support.html
  ✅ score.html
  ✅ favicon.svg
  ✅ robots.txt
  ✅ sitemap.xml
  ✅ .htaccess
  ✅ css/style.css
  ✅ css/legal.css
  ✅ css/score.css
  ✅ js/script.js
  ✅ js/score.js
  ```

---

## Deployment Steps

### Option A: Netlify (Recommended - Easiest)

- [ ] **Sign Up**
  - [ ] Go to netlify.com
  - [ ] Create free account

- [ ] **Deploy**
  - [ ] Drag and drop `website` folder
  - [ ] Wait for deployment (30 seconds)
  - [ ] Get your URL (e.g., yoursite.netlify.app)

- [ ] **Configure Domain (Optional)**
  - [ ] Add custom domain in settings
  - [ ] Update DNS records
  - [ ] Enable HTTPS (automatic)

- [ ] **Test Live Site**
  - [ ] Visit your URL
  - [ ] Test all pages
  - [ ] Test score display
  - [ ] Test on mobile

### Option B: GitHub Pages

- [ ] **Create Repository**
  - [ ] Go to github.com
  - [ ] Create new repository
  - [ ] Name it (e.g., camlivebilliard-website)

- [ ] **Upload Files**
  - [ ] Upload all website files
  - [ ] Commit changes

- [ ] **Enable GitHub Pages**
  - [ ] Go to Settings → Pages
  - [ ] Select main branch
  - [ ] Save

- [ ] **Access Site**
  - [ ] URL: username.github.io/repo-name
  - [ ] Wait 2-3 minutes for deployment

- [ ] **Test Live Site**
  - [ ] Visit your URL
  - [ ] Test all pages
  - [ ] Test score display

### Option C: Vercel

- [ ] **Sign Up**
  - [ ] Go to vercel.com
  - [ ] Create account

- [ ] **Import Project**
  - [ ] Click "New Project"
  - [ ] Import from GitHub or upload files
  - [ ] Deploy

- [ ] **Configure**
  - [ ] Set root directory to `website`
  - [ ] Deploy

- [ ] **Test Live Site**
  - [ ] Visit your URL
  - [ ] Test all pages

### Option D: Traditional Hosting (cPanel/FTP)

- [ ] **Prepare Files**
  - [ ] Zip the website folder
  - [ ] Or prepare for FTP upload

- [ ] **Upload**
  - [ ] Login to cPanel or FTP
  - [ ] Upload to public_html or www folder
  - [ ] Extract if zipped

- [ ] **Configure**
  - [ ] Verify .htaccess is uploaded
  - [ ] Set file permissions (755 for folders, 644 for files)

- [ ] **Test Live Site**
  - [ ] Visit your domain
  - [ ] Test all pages

---

## Post-Deployment Tasks

### 1. Verify Live Site ✅

- [ ] **Homepage**
  - [ ] Loads correctly
  - [ ] All sections visible
  - [ ] Navigation works
  - [ ] Mobile menu works
  - [ ] Download button works

- [ ] **Legal Pages**
  - [ ] Privacy policy loads
  - [ ] Terms loads
  - [ ] Support loads
  - [ ] All links work

- [ ] **Score Display**
  - [ ] score.html loads
  - [ ] Control panel works
  - [ ] Can update scores
  - [ ] OBS mode works

- [ ] **Mobile Testing**
  - [ ] Test on actual phone
  - [ ] Test on tablet
  - [ ] All features work

### 2. SEO Setup 🔍

- [ ] **Google Search Console**
  - [ ] Add your site
  - [ ] Submit sitemap.xml
  - [ ] Verify ownership

- [ ] **Update sitemap.xml**
  - [ ] Replace domain with your actual domain
  - [ ] Submit to Google

- [ ] **robots.txt**
  - [ ] Verify it's accessible
  - [ ] Update if needed

### 3. Analytics (Optional) 📊

- [ ] **Google Analytics**
  - [ ] Create account
  - [ ] Get tracking code
  - [ ] Add to all HTML pages (before </head>)

- [ ] **Test Tracking**
  - [ ] Visit site
  - [ ] Check real-time analytics
  - [ ] Verify tracking works

### 4. Google Play Console 🎮

- [ ] **Add Website URL**
  - [ ] Go to Play Console
  - [ ] Store presence → Store listing
  - [ ] Add website: https://yourdomain.com

- [ ] **Add Privacy Policy URL**
  - [ ] Store presence → Store listing
  - [ ] Add privacy policy: https://yourdomain.com/privacy-policy.html

- [ ] **Add Support URL**
  - [ ] Store presence → Store listing
  - [ ] Add support: https://yourdomain.com/support.html

- [ ] **Complete Data Safety**
  - [ ] Answer all questions
  - [ ] Reference your privacy policy
  - [ ] Submit

### 5. Test OBS Integration 🎬

- [ ] **Setup OBS**
  - [ ] Open OBS Studio
  - [ ] Add Browser Source
  - [ ] URL: https://yourdomain.com/score.html?obs=true
  - [ ] Size: 1920x1080

- [ ] **Test Display**
  - [ ] Scores appear
  - [ ] Background is transparent
  - [ ] Updates work
  - [ ] No control panel visible

- [ ] **Test with Android App (if integrated)**
  - [ ] Start score server in app
  - [ ] Connect OBS to server
  - [ ] Update scores in app
  - [ ] Verify updates in OBS

---

## Android App Integration

### 1. Prepare App 📱

- [ ] **Add Dependencies**
  ```gradle
  implementation 'org.nanohttpd:nanohttpd:2.3.1'
  implementation 'com.google.code.gson:gson:2.10.1'
  ```

- [ ] **Add Permissions**
  ```xml
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
  ```

- [ ] **Copy Integration Code**
  - [ ] Copy from ANDROID_INTEGRATION_EXAMPLE.kt
  - [ ] Add to your project
  - [ ] Customize as needed

### 2. Test Integration 🧪

- [ ] **Start Server**
  - [ ] Run app on device
  - [ ] Start score server
  - [ ] Note IP address

- [ ] **Test in Browser**
  - [ ] Open browser on same network
  - [ ] Navigate to http://PHONE_IP:8080/scores
  - [ ] Verify JSON response

- [ ] **Test Score Display**
  - [ ] Open score.html?server=http://PHONE_IP:8080
  - [ ] Update scores in app
  - [ ] Verify updates in browser

- [ ] **Test in OBS**
  - [ ] Add browser source
  - [ ] URL: https://yourdomain.com/score.html?obs=true&server=http://PHONE_IP:8080
  - [ ] Update scores in app
  - [ ] Verify updates in OBS

### 3. Production Setup 🚀

- [ ] **Add UI in App**
  - [ ] Button to start/stop server
  - [ ] Display server URL
  - [ ] Copy URL button
  - [ ] QR code (optional)

- [ ] **Add Settings**
  - [ ] Enable/disable remote scores
  - [ ] Port configuration
  - [ ] Auto-start option

- [ ] **Test Everything**
  - [ ] Start/stop server
  - [ ] Update scores
  - [ ] Verify updates
  - [ ] Test on different networks

---

## Final Checks ✅

### Before Launch

- [ ] All email addresses updated
- [ ] Google Play link updated
- [ ] Domain references updated
- [ ] All pages tested
- [ ] Mobile responsive verified
- [ ] Score display working
- [ ] OBS integration tested
- [ ] Privacy policy accurate
- [ ] Terms & conditions accurate
- [ ] Support page helpful

### After Launch

- [ ] Site is live and accessible
- [ ] All pages load correctly
- [ ] HTTPS is working
- [ ] Mobile version works
- [ ] Score display accessible
- [ ] Added to Google Play Console
- [ ] Sitemap submitted to Google
- [ ] Analytics tracking (if added)
- [ ] Social media sharing works
- [ ] Favicon displays

---

## Troubleshooting 🔧

### Common Issues

**Site not loading:**
- Check DNS settings
- Wait for DNS propagation (up to 48 hours)
- Verify files uploaded correctly

**Mobile menu not working:**
- Clear browser cache
- Check JavaScript is enabled
- Verify script.js loaded

**Score display not working:**
- Check browser console for errors
- Verify score.js loaded
- Test with demo mode first

**OBS not showing overlay:**
- Verify URL has ?obs=true
- Check size is 1920x1080
- Refresh browser source
- Check if behind other sources

**Android integration issues:**
- Verify server is running
- Check firewall settings
- Ensure same network
- Test with browser first

---

## Success Criteria ✨

Your deployment is successful when:

✅ Website is live and accessible
✅ All pages load correctly
✅ Mobile version works perfectly
✅ Score display is functional
✅ OBS integration works
✅ Added to Google Play Console
✅ Privacy policy is accessible
✅ Support page is helpful
✅ All links work
✅ HTTPS is enabled

---

## Next Steps After Deployment 🎯

1. **Monitor Performance**
   - Check Google Analytics
   - Monitor page load times
   - Check for errors

2. **Gather Feedback**
   - Ask users to test
   - Collect suggestions
   - Fix any issues

3. **Promote Your App**
   - Share website link
   - Post on social media
   - Submit to app directories

4. **Keep Updated**
   - Update content regularly
   - Add new features
   - Fix bugs promptly

---

## Support 📞

Need help?
- Check documentation files
- Test with demo mode
- Review troubleshooting section
- Contact: support@camlivebilliard.com

---

**Deployment Checklist v1.0**  
**Last Updated:** November 29, 2024  
**Status:** Ready for Production ✅

**Good luck with your launch! 🚀🎱**
